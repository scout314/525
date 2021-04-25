<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>航班详情</title>
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
			<div class="col-md">

				<div class="card">
					<div class="card-header">航班详情</div>
					<div class="card-body">
						<form>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">航班编号</label>
								<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext"
										id="staticEmail" value="${flightinfo.f_no}">
								</div>
							</div>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">出发地点</label>
								<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext"
										id="staticEmail" value="${flightinfo.f_start}">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPassword" class="col-sm-2 col-form-label">到达地点</label>
								<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext"
										id="staticEmail" value="${flightinfo.f_dist}">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPassword" class="col-sm-2 col-form-label">价格</label>
								<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext"
										id="staticEmail" value="${flightinfo.f_price}">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPassword" class="col-sm-2 col-form-label">出发时间</label>
								<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext"
										id="staticEmail" value="${flightinfo.f_time}">
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>

			

		</div>
	</div>

	<!-- 引入的bootstrap4-->
	<%@ include file="bt.jsp"%>

</body>
</html>