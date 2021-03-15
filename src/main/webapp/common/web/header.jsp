<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					
					<security:authorize access = "isAnonymous()">
						<li class="nav-item"><a class="nav-link" href='<c:url value="/dang-nhap"/>'>Đăng nhập</a></li>
						<li class="nav-item"><a class="nav-link" href='<c:url value="/dang-ki"/>'>Đăng kí</a></li>
					</security:authorize>
					
					
					<security:authorize access = "isAuthenticated()">
						<li class="nav-item"><a class="nav-link" href='#'>WellCome,<%=SecurityUtils.getPrincipal().getFullName()%></a></li>
						<li class="nav-item"><a class="nav-link" href='<c:url value="/thoat"/>'>Thoát</a></li>
					</security:authorize>
				

				</ul>
			</div>
		</div>
	</nav>

</body>
</html>