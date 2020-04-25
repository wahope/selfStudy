$(function(){
    $("#sign").click(function () {
        console.log($("#uid").val());
        console.log($("#psw1").val());
        console.log($("#nickname").val());
        // var phone = parseInt($("#mobile").val());
        // console.log(phone);
        $.ajax({
            url:"http://localhost:8080/User/sign",
            dataType:"json",
            // contentType : "application/json",
            type:"POST",
            data:{
                userName:$("#uid").val(),
                password:$("#psw1").val(),
                // mobile:JSON.stringify(phone),
                // mobile:$("#mobile").val(),
                address:$("#nickname").val()
            },success:function (resultData) {
                var code = parseInt(resultData.msg);
                if(code ==1){
                    location.href="http://localhost:8080/page/login.html"
                }else{
                    alert("用户名已存在！");
                }
            },error:function () {
                alert("注册失败！");
            }
        })
    })
})