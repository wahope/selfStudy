<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>淌漾自学网登录</title>
    <link rel="stylesheet" href="../cssl/sign.css">
    <script src="/js/jquery-2.2.4-min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="../jsl/easyform.js"></script>
</head>

<body>
<br>
<div class="form-div" style="margin-top: 80px;">
    <form id="reg-form">

        <table>
            <tr>
                <td>用户名</td>
                <td><input name="uid" type="text" id="uid" easyform="length:1-16;char-chinese;real-time;" message="用户名必须为4—16位的英文字母或数字" easytip="disappear:lost-focus;theme:blue;" ajax-message="用户名已存在!">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input name="psw1" type="password" id="psw1" easyform="length:1-16;" message="密码必须为1—16位" easytip="disappear:lost-focus;theme:blue;"></td>
            </tr>

        </table>

        <div class="buttons">
            <input id="login" value="我有账号，我要登录" type="button" style="margin-right:45px; margin-top:20px;">
        </div>

        <br class="clear">
    </form>
</div>
<script type="text/javascript" src="/js/login.js"></script>
</body>
</html>


