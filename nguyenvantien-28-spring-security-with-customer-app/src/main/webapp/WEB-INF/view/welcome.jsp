<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/taglib/import.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div style="margin: 20px">
		<h1>Spring Home Page - Welcome</h1>
		<hr>
		<div>Welcome to Spring Home Page</div>
		<div>I wish You all the best</div>
		<hr>
		<a href="${contextPath}/login" class="btn btn-primary"
			aria-pressed="true"> Login</a> <a href="${contextPath}/signup"
			class="btn btn-primary" aria-pressed="true"> Sign up</a>
	</div>
</body>
</html>