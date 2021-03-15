<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>

	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">

				<form action="j_spring_security_check" id="formLogin"
					method="post">
					<c:if test="${param.incorrectAccount != null}">
						<div class="alert alert-danger" role="alert">Username or password incorrect</div>
					</c:if>
					
					<c:if test="${param.accessDenied != null}">
						<div class="alert alert-danger" role="alert">You not authorize</div>
					</c:if>
					
					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="j_password" placeholder="Mật khẩu">
					</div>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>