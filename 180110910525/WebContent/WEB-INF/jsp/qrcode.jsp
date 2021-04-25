<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的钱包</title>



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

				<div class="card">
					<div class="card-header">
						<p>你好</p>
					</div>
					<div class="card-body">
						<h5 class="card-title">我的钱包</h5>
						<p class="card-text">
							<img src="qrimg/${img_filename}"  />
						<p>二维码文本内容 ：${img_txt}</p>

						<form method="post" action="QrCode">
							<p>

								<textarea rows="5" cols="30" name="input_text">请输入需要充值的金额</textarea>

							</p>

							

							<p>
								<input type="submit" value="生成充值二维码">
							</p>
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