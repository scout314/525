<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>机票预订</title>
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
				<form class="form-inline" method="post" action="QueryFlightServlet">
					<div class="form-group">
						<label for="exampleInputName2">出发地</label> <input type="text"
							class="form-control" id="exampleInputName1" placeholder="出发地"
							name="start">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail2">目的地</label> <input type="text"
							class="form-control" id="exampleInputName2" placeholder="目的地"
							name="dist">
					</div>
					<button type="submit" class="btn btn-default">查询</button>
					</form>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>航班编号</th>
								
								<th>起始地</th>
								<th>目的地</th>
								<th>价格</th>
								<th>出发时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="f" items="${flight}">
								<tr>
									<td>${f.f_no}</td>
									
									<td><c:out value="${f.f_start}" /></td>
									<td><c:out value="${f.f_dist}" /></td>
									<td><c:out value="${f.f_price}" /></td>
									<td><c:out value="${f.f_time}" /></td>
									<td>
										<button type="button" class="btn btn-xs btn-success"
											onclick="javascript:window.location.href='AddOrder';">预订</button>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>

				<!-- 引入的bootstrap4-->
				<%@ include file="bt.jsp"%>
</body>
</html>