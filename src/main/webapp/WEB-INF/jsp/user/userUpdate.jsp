<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户信息修改</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="/css/public.css" media="all" />
	<style type="text/css">
		.layui-col-space10{
			margin-left:2.5em;
		}
		.layui-form-item magt3{
			width: auto;
		}
		.layui-form-label{
			width: 120px;
			text-align: center;
		}
		.layui-input-block{
			margin-left: 13em;
			width: 34em;
		}
	</style>
</head>
<body class="childrenBody">
<form class="layui-form layui-row layui-col-space10">
	<div class="layui-col-md9 layui-col-xs12">
		<div class="layui-row layui-col-space10">
			<div class="layui-form-item magt3">
				<div class="layui-form-item magt3">
					<label class="layui-form-label">ID</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input id" lay-verify="id" disabled>
					</div>
				</div>
			</div>
			<div class="layui-form-item magt3">
				<label class="layui-form-label">用户名 </label>
				<div class="layui-input-block">
					<input type="text" class="layui-input userName" disabled lay-verify="userName" placeholder="请输入资料标题">
				</div>
			</div>
			<div class="layui-form-item magt3">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-block">
					<input type="password" class="layui-input password" lay-verify="password" placeholder="请输入资料标题">
				</div>
			</div>
			<div class="layui-form-item magt3">
				<label class="layui-form-label">电话号码</label>
				<div class="layui-input-block">
					<input type="tel" class="layui-input mobile" lay-verify="mobile" placeholder="请输入资料标题">
				</div>
			</div>
			<div class="layui-form-item magt3">
				<label class="layui-form-label">住址</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input address" lay-verify="address" placeholder="请输入资料标题">
				</div>
			</div>
			<div class="layui-form-item magt3">
				<label class="layui-form-label">注册时间</label>
				<div class="layui-input-block">
					<input type="text" disabled class="layui-input createTime" lay-verify="createTime" placeholder="请输入资料标题">
				</div>
			</div>
			<div class="layui-form-item magt3">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input remark" lay-verify="remark">
				</div>
			</div>
		</div>

		<div class="layui-right">
			<a class="layui-btn layui-btn-sm" lay-filter="updateUser" lay-submit><i class="layui-icon">&#xe609;</i>修改</a>
		</div>
	</div>
	</div>

	</div>
	</div>
</form>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/js/user/userList.js"></script>
<script type="text/javascript" src="/js/user/userUpdate.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
</body>
</html>