<%@ include file="/WEB-INF/tag-lib/import.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
	<title>Welcome page</title>
	<link rel="stylesheet" href="${ contextPath }/resources/css/style.css">
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
	<h2>Spring home page. Welcome!</h2>
	
	<hr>
	<a href="${ contextPath }/login" class="btn btn-link" role="button" aria-pressed="true">
	Login
	</a>
	<a href="${ contextPath }/signUp" class="btn btn-primary" role="button" aria-pressed="true">
	Register
	</a>
	
	
</body>
</html>
