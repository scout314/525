<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
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
						<h5 class="card-title">欢迎登录</h5>
						<p class="card-text">
						<p style="color: red">${info}</p>

						<form method="post" action="LoginAction">
							<p>
								姓名:<input type="username" name="username" value="${input_name}">
							</p>

							<p>
								密码:<input type="password" name="password" value="">
							</p>

							
							<p>
								校验码:<input type="text" name="jym" value="" size="5"><img
									src="ResponseImage" style="vertical-align: middle;">
							</p>
							<div class="form-group form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">记住密码</label>
							</div>
							<p>
								<button type="submit" class="btn btn-primary" onclick="login()">登录</button>
							    <button class="btn btn-primary" type="button" onclick="javascript:window.location.href='Register';">注册</button> 
							</p>
							
  

						</form>

					</div>
				</div>
			</div>



			<!-- 引入的bootstrap4-->
			<%@ include file="bt.jsp"%>
</body>
</html>