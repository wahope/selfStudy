$(function () {
    $("#login").click(function () {
        $.ajax({
            url:"http://localhost:8080/User/login",
            method:"post",
            type:"json",
            data:{
                userName:$("#uid").val(),
                pass:$("#psw1").val()
            },
            success: function (msg) {
                console.log(msg);
                sessionStorage.setItem("userName",msg.data.userName)
                sessionStorage.setItem("userId",msg.data.id)
                location.href = "../page/index.html";
            }, error: function (msg) {
                alert("用户名或密码错误");
            }
        })
    })
});