layui.use(['form','jquery','layer','layedit','laydate','upload','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;


    //用于同步编辑器内容到textarea
    layedit.sync(editIndex);



    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }


    form.on("submit(updateUser)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        console.log($(".userName").val());
        $.ajax({
            url:"http://localhost:8080/BackUser/updateUser",
            type:"post",
            dataType: 'json',
            data:{
                id:$(".id").val(),
                userName : $(".userName").val(),
                password : $(".password").val(),
                mobile : $(".mobile").val(),
                address : $(".address").val(),
                remark : $(".remark").val()
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

    //创建一个编辑器
    var editIndex = layedit.build('content',{
        height : 535,
        value:$("#content").val(),
        uploadImage : {
            url : "/json/newsImg.json"
        }
    });

})