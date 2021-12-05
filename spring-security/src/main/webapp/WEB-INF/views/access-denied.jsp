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
<title>Forbidden 403</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	
	<h3>Access denied - You have not authorized this resource</h3>
	<br>
	<p>
		<a href="${contextPath }/home">Back to home page</a>
	</p>
	
</body>
</html>