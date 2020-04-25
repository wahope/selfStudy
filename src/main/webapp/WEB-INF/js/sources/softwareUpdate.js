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
        loadDevice(datas);
        console.log(datas);

    });
    function loadDevice(departmentId) {
        // console.log(departmentId);
        $.ajax({
            url: 'http://localhost:8080/BackStage/selStageBySpe?specialtyId=' + departmentId,
            type: 'POST',
            dataType: 'JSON',
            error: function() { alert('加载数据异常2，请重试!'); },
            success: function (msg) {
                // console.log(msg);
                // for (var i=0;i<msg.length;i++) {
                //     var stagea=msg.stageName;
                //     console.log(stagea);
                //     $(
                //         "<option value='"+msg.id+"'>"+stagea+"</option>"
                //     ).appendTo($("#stage"));
                // }
                $.each(eval(msg), function (i,item) {
                    console.log(item);
                    // console.log($("#stage"));
                    var stage = item.stageName;
                    // console.log(stage);
                    // console.log(item.id);
                    $(
                        "<option value='"+item.id+"'>"+stage+"</option>"
                    ).appendTo($("#stage"));

                });
            }

        });
        form.render('select');//一定要加form.render();
    }
    $.ajax({
        url: 'http://localhost:8080/BackSpe/selectAllSpe',
        type: 'POST',
        dataType: 'JSON',
        error: function() { alert('加载数据异常1，请重试!'); },
        success: function (data) {
            // console.log(data);
            $.each(eval(data), function (i, item) {
                   // console.log(item.id);
                   //  console.log($("#specialty"));
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
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());
    laydate.render({
        elem: '#release',
        type: 'datetime',
        trigger : "click",
        done : function(value, date, endDate){
            submitTime = value;
        }
    });

    form.on("submit(updateSof)",function(data){
        //更新时间
        // console.log($("#stage").val());

        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //传入对象
        // var ssSoftware = {
        //     id:$(".id").val(),
        //     softwareName : $(".software_name").val(),  //软件名称
        //     stageId : $(".stage_id").val(),  //阶段id
        //     dowsoftUrl : $(".dowsoftUrl").val(),  //下载地址
        //     sofinstallUrl : $(".sofinstallUrl").val(),  //安装指南
        //     envconfigUrl : $(".envconfigUrl").val(),  //文章摘要
        //     createTime : $(".createTime").val(),  //创建时间
        //     updateTime : time,  //更新时间
        //     remark : $(".remark").val(),  //备注
        // };
        // 实际使用时的提交信息
        $.ajax({
            url:"http://localhost:8080/BackSof/updateSof",
            type:"post",
            dataType: 'json',
            // contentType : 'application/json',
            // data:JSON.stringify(ssSoftware),
            data:{
                id:$(".id").val(),
                softwareName : $(".softwareName").val(),  //软件名称
                stageId : $("#stage").val(),  //阶段id
                dowsoftUrl : $(".dowsoftUrl").val(),  //下载地址
                sofinstallUrl : $(".sofinstallUrl").val(),  //安装指南
                // envconfigUrl : $(".envconfigUrl").val(),  //文章摘要
                remark : $(".remark").val()  //备注
            },
            success:function (data) {
                console.log(data.msg);
                setTimeout(function(){
                    top.layer.close(index);
                    // top.layer.msg("软件修改成功！");
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },500);
            },error:function (data) {
                console.log("失败");
            }
        });

        // setTimeout(function(){
        //     top.layer.close(index);
        //     // top.layer.msg("软件修改成功！");
        //     layer.closeAll("iframe");
        //     //刷新父页面
        //     parent.location.reload();
        // },500);
        return false;
    })

    form.on("submit(addSof)",function(data){
        //更新时间
        // console.log($("#stage").val());

        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //传入对象
        // var ssSoftware = {
        //     id:$(".id").val(),
        //     softwareName : $(".software_name").val(),  //软件名称
        //     stageId : $(".stage_id").val(),  //阶段id
        //     dowsoftUrl : $(".dowsoftUrl").val(),  //下载地址
        //     sofinstallUrl : $(".sofinstallUrl").val(),  //安装指南
        //     envconfigUrl : $(".envconfigUrl").val(),  //文章摘要
        //     createTime : $(".createTime").val(),  //创建时间
        //     updateTime : time,  //更新时间
        //     remark : $(".remark").val(),  //备注
        // };
        // 实际使用时的提交信息
        $.ajax({
            url:"http://localhost:8080/BackSof/insertSof",
            type:"post",
            dataType: 'json',
            // contentType : 'application/json',
            // data:JSON.stringify(ssSoftware),
            data:{
                softwareName : $(".softwareName").val(),  //软件名称
                stageId : $("#stage").val(),  //阶段id
                dowsoftUrl : $(".dowsoftUrl").val(),  //下载地址
                sofinstallUrl : $(".sofinstallUrl").val(),  //安装指南
                // envconfigUrl : $(".envconfigUrl").val(),  //文章摘要
                remark : $(".remark").val()  //备注
            },
            success:function (data) {
                console.log(data.msg);
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.msg("软件添加成功！");
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },500);
            },error:function (data) {
                console.log("失败");
            }
        });

        // setTimeout(function(){
        //     top.layer.close(index);
        //     // top.layer.msg("软件修改成功！");
        //     layer.closeAll("iframe");
        //     //刷新父页面
        //     parent.location.reload();
        // },500);
        return false;
    })

    //预览
    form.on("submit(look)",function(){
        layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问");
        return false;
    })

    //创建一个编辑器
    var editIndex = layedit.build('news_content',{
        height : 535,
        uploadImage : {
            url : "/json/newsImg.json"
        }
    });

})