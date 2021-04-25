<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- 左边栏 -->
<div class="col-md-3">
	<div class="list-group">
		<a href="${pageContext.request.contextPath}/Main" class="list-group-item list-group-item-action ${menu_item=='Index'?'active':'' }">首页</a>
		<a href="${pageContext.request.contextPath}/BookFlight" class="list-group-item list-group-item-action ${menu_item=='Login'?'active':'' }">机票列表</a> 
		<a href="${pageContext.request.contextPath}/QueryFlight" class="list-group-item list-group-item-action ">航班查询</a>
		<a href="${pageContext.request.contextPath}/MyOrder" class="list-group-item list-group-item-action ${menu_item=='Qrcode'?'active':'' }">我的订单</a>
		<a href="${pageContext.request.contextPath}/QrCode1" class="list-group-item list-group-item-action">我的钱包 </a>
		<a href="${pageContext.request.contextPath}/FlightInfo" class="list-group-item list-group-item-action">航班详情 </a>
	</div>
</div>

