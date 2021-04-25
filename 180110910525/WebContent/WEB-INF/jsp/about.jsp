<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>关于本站</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<! --页面总容器 -->
	<div class="container">
		<!-- Content here -->

		<!-- 导航条 -->
		<%@ include file="hd.jsp"%>

		<div class="row" style="margin-top: 10px">


			<!-- 左侧侧边栏 -->
			<%@ include file="left.jsp"%>

			<!-- 中间内容 -->
			<div class="col">

				<div class="card"></div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h1 class="page-header">你好！</h1>
					
				</div>
				<div class="card-body">
				<p>本系统是一个主要用于机票查看以及搜索的网页，同时也为用户提供一个购买的功能</p>
				<p>当然想要使用本站需要进行登录，如果未进行登录，请注册</p>
				</div>

				<!-- 引入的bootstrap4-->
				<%@ include file="bt.jsp"%>
</body>
</html>