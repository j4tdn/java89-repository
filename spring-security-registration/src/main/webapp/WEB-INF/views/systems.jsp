<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring system page</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	
	<h2>System Page - Welcome</h2>
	
	<p>User: <security:authentication property="principal.username"/> </p>
	<p>Role: <security:authentication property="principal.authorities"/> </p>
	<p> Firstname: ${user.firstName }, Lastname: ${user.lastName } </p>	
	<form:form method="POST" action="${contextPath }/logout">
		<input type="submit" value="logout">
	</form:form>
	
	<p>
		<a href="${contextPath }/home">Back to home page</a>
	</p>
</body>
</html>