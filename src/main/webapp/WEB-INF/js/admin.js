$(function () {
    var admin = $(".adminName").html();
    console.log(admin);
	$(".signOut").click(function () {
		$.ajax({
            url:"http://localhost:8080/loginOut",
			type:"post",
			success:function () {
            	location.href="http://localhost:8080/logins";
            }
        })
    });


})