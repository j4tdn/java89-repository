<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
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
</head>
<body>
	<h1 class="text-success">Spring welcome - Home Page</h1>
	<p>Welcome to Spring home page</p>

	<br>
	<br>
	<button class="text-primary btn btn-light">
		<a class="text-primary btn btn-light" href="${pageContext.request.contextPath}/login"> Login </a>
	</button>
	<button class="btn btn-primary">
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/signup"> SignUp </a>
	</button>
</body>
</html>