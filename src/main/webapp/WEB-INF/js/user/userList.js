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
        url : 'http://localhost:8080/BackUser/selectAllUser',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 5,
        limits : [1,5,10,15,20,25],
        id : "newsListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: 'ID', width:60, align:"center",sort: true},
            {field: 'userName', title: '用户名', width:120,align:"center"},
            {field: 'password', title: '密码', align:'center',width:80},
            {field: 'mobile', title: '手机号码', align:'center',width:180},
            {field: 'address', title: '住址', align:'center',width:75},
            {field: 'createTime', title: '注册时间', align:'center', minWidth:100},
            {field: 'remark', title: '备注', align:'center'},
            {title: '操作', width:170, templet:'#newsListBar',fixed:"right",align:"center"}
        ]]
    });

    //修改网盘资料
    function addNews(edit){
        var ids = edit.id;
        console.log(ids);
        var index = layui.layer.open({
            title : "修改用户信息",
            type : 2,
            content : 'http://localhost:8080/BackUser/toUpdateUser?id='+ids,
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".id").val(edit.id);
                    body.find(".userName").val(edit.userName);
                    body.find(".password").val(edit.password);
                    body.find(".mobile").val(edit.mobile);
                    body.find(".address").val(edit.address);
                    body.find(".createTime").val(edit.createTime);
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


    //列表操作
    table.on('tool(newsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        var id = data.id;
        if(layEvent === 'edit'){ //编辑
            addNews(data);
        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '提示信息'}, function (index) {
                $.post("http://localhost:8080/BackUser/delUser",{
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