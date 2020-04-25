$(function () {
    $("#login").click(function () {
        $.ajax({
            url:"http://localhost:8080/toLogin",
            method:"post",
            type:"json",
            data:{
                account:$("#uid").val(),
                password:$("#psw1").val()
            },
            success: function (msg) {
                console.log(msg);
                location.href = "http://localhost:8080/index";
            }, error: function (msg) {
                alert("用户名或密码错误");
            }
        })
    })
});