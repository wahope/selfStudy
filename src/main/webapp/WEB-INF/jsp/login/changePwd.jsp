<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>修改密码</title>
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="/layui/css/layui.css" media="all" />
	<style type="text/css">
		/*修改密码*/
		.changePwd{ width:90%; margin:3% auto; }
	</style>
</head>
<body class="childrenBody">
<div style="padding: 20px; background-color: #F2F2F2;">
	<form class="layui-form changePwd" id="cpwd">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" value="${ADMIN.account}" disabled class="layui-input layui-disabled" id = "username">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">旧密码</label>
			<div class="layui-input-block">
				<input type="password" value="" placeholder="请输入旧密码" lay-verify="oldPwd" class="layui-input pwd" name="oldPwd" id="oldPwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">新密码</label>
			<div class="layui-input-block">
				<input type="password"  value="" placeholder="请输入新密码" lay-verify="newPwd" id="newPwd" class="layui-input pwd" name="newPwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input type="password" value="" placeholder="请确认密码" lay-verify="repass" class="layui-input pwd" >
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="changePwd" lay-filter="changePwd">立即修改</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript">
    var $;
    var form;
    layui.config({
        base : "/js/"
    }).use(['form','layer','jquery','laydate'],function(){
        var layer = parent.layer === undefined ? layui.layer : parent.layer,
            laypage = layui.laypage,laydate = layui.laydate;
        $ = layui.jquery;
        form = layui.form;

        //自定义验证规则
        form.verify({
            oldPwd: [/(.+){5,16}$/, '密码必须5到16位'],
            newPwd: [/(.+){5,16}$/, '密码必须5到16位'],
            repass: function(value){
                var repassvalue = $('#newPwd').val();
                if(value != repassvalue){
                    return '两次输入的密码不一致!';
                }
            }
        });

        form.on("submit(changePwd)",function(data){
            //弹出loading
			// console.log(data.field.oldPwd);
			// console.log(data.field.newPwd);
            $.ajax({
                type: "post",
                url: "http://localhost:8080/updatePassword",
                async:false,
                data:{
                    account: $("#username").val(),
                    oldPsw : data.field.oldPwd,
                    newPsw : data.field.newPwd
                },
                dataType:"json",
                success : function(msg) {
                    console.log(msg);
                    if (msg.msg =="1") {
                        layer.alert('您成功修改了密码，现将跳转至登陆页面重新登陆！ (*^v^*)', {
                            icon: 6,
                            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                        },function () {
                            window.parent.location.href="http://localhost:8080/logins";
                        });
                    }else{
                        layer.alert("密码修改失败" + "つ﹏⊂", {
                            icon: 5,
                            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                        });
                    }
                },
                error : function () {
                    layer.msg('程序猿偷懒了，没写好接口 (⊙ˍ⊙)', {icon: 5});
                }
            })
            return false;
        })

    })
</script>
</body>
</html>