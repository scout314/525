<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h1 class="page-header">你好！</h1>
				</div>
				<h2 class="sub-header">查询到如下航班信息</h2>
          <div class="table-responsive">
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
                  
                  <td><c:out value="${f.f_start}"/></td>
                  <td><c:out value="${f.f_dist}"/></td>
                  <td><c:out value="${f.f_price}"/></td>
                  <td><c:out value="${f.f_time}"/></td>
                  <td><a type="button" href="FlightInfo?f_no=${f.f_no}"
											class="btn btn-primary">详情</a></td>
                </tr>
			</c:forEach>
                
              </tbody>
            </table>
            
          </div>
          <nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/BookFlight?pageNo=${page.first}">第一页</a></li>
    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/BookFlight?pageNo=${page.prev}">上一页</a></li>
    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/BookFlight?pageNo=${page.next}">下一页</a></li>
    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/BookFlight?pageNo=${page.last}">最后一页</a></li>
    
  </ul>
</nav>

				<!-- 引入的bootstrap4-->
				<%@ include file="bt.jsp"%>
</body>
</html>