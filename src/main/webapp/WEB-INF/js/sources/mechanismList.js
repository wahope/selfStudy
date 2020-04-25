layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#newsList',
        url : 'http://localhost:8080/BackMec/selectAllMec',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "newsListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: 'ID', width:60, align:"center",sort: true},
            {field: 'mechanismName', title: '网站名称', width:100,align:"center"},
            {field: 'stageId', title: '专业阶段', align:'center',width:80},
            {field: 'stageName', title: '阶段名称', align:'center',width:100},
            {field: 'mechanismUrl', title: '网站地址', align:'center', width:270},
            {field: 'createTime', title: '发布时间', align:'center', minWidth:130},
            {field: 'updateTime', title: '更新时间', align:'center', minWidth:130},
            {field: 'remark', title: '备注', align:'center'},
            {title: '操作', width:170, templet:'#newsListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //修改网盘资料
    function addNews(edit){
        var ids = edit.id;
        console.log(ids);
        var index = layui.layer.open({
            title : "修改网站信息",
            type : 2,
            content : 'http://localhost:8080/BackMec/toUpdateMec?id='+ids,
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".id").val(edit.id);
                    body.find(".mechanismName").val(edit.mechanismName);
                    body.find(".stageId").val(edit.stageId);
                    body.find(".mechanismUrl").val(edit.mechanismUrl);
                    body.find(".createTime").val(edit.createTime);
                    body.find(".updateTime").val(edit.updateTime);
                    body.find(".remark").val(edit.remark);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }
    $(".addNews_btn").click(function(){
        addNews();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('newsListTable'),
            data = checkStatus.data,
            newsId='';
        if(data.length > 0) {
            for (var i in data) {
                newsId+=data[i].id+',';
            }
            newsId=newsId.substring(0,newsId.length-1);
            // console.log(newsId);
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '提示信息'}, function (index) {
                $.post("http://localhost:8080/BackMec/delMoreMec",{
                    ids : newsId  //将需要删除的newsId作为参数传入
                },function(data){
                    tableIns.reload();
                    layer.close(index);
                })
            })
        }else{
            layer.msg("请选择需要删除的文章");
        }
    })

    //列表操作
    table.on('tool(newsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        var id = data.id;
        if(layEvent === 'edit'){ //编辑
            addNews(data);
        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '提示信息'}, function (index) {
                $.post("http://localhost:8080/BackMec/delMec",{
                    id : id  //将需要删除的newsId作为参数传入
                },function(data){
                    // console.log(data.msg);
                    tableIns.reload();
                    layer.close(index);
                })
            })
        }
    });

})