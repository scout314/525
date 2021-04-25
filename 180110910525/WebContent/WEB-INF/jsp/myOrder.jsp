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

				<h2 class="sub-header">你有如下条订单</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>订单编号</th>
				<th>起始地</th>
				 <th>目的地</th>
				 <th>价格</th>
				
				
				 <th>操作</th>
                </tr>
              </thead>
              <tbody>
			<c:forEach var="o" items="${order}">
				 <tr>
                  <td><c:out value="${o.o_no}"/></td>
                  <td><c:out value="${o.o_f_start}"/></td>
                  <td><c:out value="${o.o_f_dist}"/></td>
                  <td><c:out value="${o.o_f_price}"/></td>
                 
                  
                  <td><a type="button" href="#"
											class="btn btn-primary">支付</a></td>
                </tr>
			</c:forEach>
                
              </tbody>
            </table>
            
          </div>
            
          </div>

				<!-- 引入的bootstrap4-->
				<%@ include file="bt.jsp"%>
</body>
</html>