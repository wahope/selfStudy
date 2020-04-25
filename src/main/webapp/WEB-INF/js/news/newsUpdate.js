layui.use(['form','jquery','layer','layedit','laydate','upload','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;

    //二级联动,监听提交
    var datas;
    form.on('select(specialty)', function(data){
//            console.log(data.elem); //得到select原始DOM对象
//            console.log(data.value); //得到被选中的值
        datas=data.value;
        console.log(datas);

    });

    $.ajax({
        url: 'http://localhost:8080/BackSpe/selectAllSpe',
        type: 'POST',
        dataType: 'JSON',
        error: function() { alert('加载数据异常1，请重试!'); },
        success: function (data) {
            // console.log(data);
            $.each(eval(data), function (i, item) {
                var specialtyName = item.specialtyName;
                // console.log(specialtyName);
                $(
                    "<option value='" + item.id + "'>"+specialtyName+"</option>"
                ).appendTo($("#specialty"));
            });
            form.render('select');//一定要加form.render();
        }
    });

    //用于同步编辑器内容到textarea
    layedit.sync(editIndex);

    //上传缩略图
    upload.render({
        elem: '.thumbBox',
        url: '/json/userface.json',
        method : "get",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res, index, upload){
            var num = parseInt(4*Math.random());  //生成0-4的随机数，随机显示一个头像信息
            $('.thumbImg').attr('src',res.data[num].src);
            $('.thumbBox').css("background","#fff");
        }
    });

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }


    form.on("submit(updateNews)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

        $.ajax({
            url:"http://localhost:8080/BackNews/updateNews",
            type:"post",
            dataType: 'json',
            data:{
                id:$(".id").val(),
                title : $(".title").val(),  //软件名称
                specialtyId : $("#specialty").val(),  //阶段id
                content : $("#content").val(),  //下载地址
                remark : $(".remark").val()  //备注
            },
            success:function (data) {
                console.log(data.msg);
                setTimeout(function(){
                    top.layer.close(index);
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },500);
            },error:function (data) {
                console.log("失败");
            }
        });

        return false;
    })

    form.on("submit(addNews)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        console.log($("#stage").val());
        $.ajax({
            url:"http://localhost:8080/BackNews/insertNews",
            type:"POST",
            dataType: 'json',
            data:{
                title : $(".title").val(),  //软件名称
                specialtyId : $("#specialty").val(),  //阶段id
                content : $("#content").val(),  //下载地址
                remark : $(".remark").val()  //备注
            },
            success:function (data) {
                console.log(data.msg);
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.msg("添加成功！");
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },500);
            },error:function (data) {
                console.log("失败");
            }
        });
        return false;
    })


    //创建一个编辑器
    var editIndex = layedit.build('content',{
        height : 535,
        value:$("#content").val(),
        uploadImage : {
            url : "/json/newsImg.json"
        }
    });

})