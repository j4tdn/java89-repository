<%@ include file="/WEB-INF/tag-lib/import.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
	<title>Login Page</title>
	<link rel="stylesheet" href="${ contextPath }/resources/css/style.css">
</head>
<body>
	
	<h2>Spring home page. Welcome!</h2>
	
	<hr>
	<p>Visit our customer page here: 
		<a href="${ contextPath }/customer">page</a>
	</p>
	
	<hr>
	<p> User: <security:authentication property="principal.username"/> </p>
	<p> Role: <security:authentication property="principal.authorities"/> </p>
	
	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${ contextPath }/leaders">Leadership meeting (Only for manager)</a>
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${ contextPath }/systems">IT System meeting (Only for admin)</a>
		</p>
	</security:authorize>
	
	<form:form method="POST" action="${contextPath}/logout">
		<input type="submit" value="logout">
	</form:form>
</body>
</html>
