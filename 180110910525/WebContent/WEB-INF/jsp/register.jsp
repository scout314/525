<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<! --页面总容器 -->
	<div class="container">
		<!-- Content here -->
		<!-- 中间内容 -->
		<div class="col">

			<div class="card">

				<div class="card-header">
					<h2 class="form-signin-heading">航班预定管理系统</h2>
				</div>
				<div class="card-body">
					
					<p class="card-text">
					<h2 class="sub-header">用户注册</h2>
					<form class="form-horizontal" role="form" method="post" action="RegAction">

						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input class="form-control" id="focusedInput" type="text"
									name="username">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">用户密码</label>
							<div class="col-sm-10">
								<input type="password" id="inputPassword" class="form-control"
									name="password" placeholder="password" required="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">用户身份证号</label>
							<div class="col-sm-10">
								<input class="form-control" id="focusedInput" type="text"
									name="id">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">用户昵称</label>
							<div class="col-sm-10">
								<input class="form-control" id="focusedInput" type="text"
									name="nickname">
							</div>
						</div>
						<button type="submit" class="btn btn-primar">提交</button>
					</form>

				</div>
			</div>


			<!-- 引入的bootstrap4-->
			<%@ include file="bt.jsp"%>
</body>
</html>