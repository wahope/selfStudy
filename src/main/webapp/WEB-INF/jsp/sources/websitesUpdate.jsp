<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>文章列表--layui后台管理模板 2.0</title>
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
					<label class="layui-form-label">ID</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input id" lay-verify="id" disabled>
					</div>
				</div>
				<div class="layui-form-item magt3">
					<label class="layui-form-label" style="margin-right: 33px;">阶段Id</label>
					<div class="layui-input-inline">
						<select name="specialty" id="specialty" lay-filter="specialty" >
							<%--动态添加select的时候，一定要加一个默认的option，不然会报错--%>
							<option></option>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="state" id="stage" lay-filter="stage">
							<%--动态添加select的时候，一定要加一个默认的option，不然会报错--%>
								<option></option>
						</select>
					</div>

				</div>
				<div class="layui-form-item magt3">
					<label class="layui-form-label">网盘标题</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input websitesName" lay-verify="websitesName" placeholder="请输入资料标题">
					</div>
				</div>
				<div class="layui-form-item magt3">
					<label class="layui-form-label">下载地址</label>
					<div class="layui-input-block">
						<input type="url" class="layui-input websitesUrl" lay-verify="websitesUrl" placeholder="请输入资料下载地址">
					</div>
				</div>
				<div class="layui-form-item magt3">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input createTime" lay-verify="createTime" disabled>
					</div>
				</div>
				<div class="layui-form-item magt3">
					<label class="layui-form-label">更新时间</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input updateTime" lay-verify="updateTime" disabled>
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
			<a class="layui-btn layui-btn-sm" lay-filter="updateWeb" lay-submit><i class="layui-icon">&#xe609;</i>修改</a>
		</div>
		</div>
	</div>


		</div>
	</div>
</form>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/js/sources/websitesList.js"></script>
<script type="text/javascript" src="/js/sources/websitesUpdate.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
</body>
</html>