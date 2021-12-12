<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring home page</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

	<h1 class="text-success">Spring welcome - Home Page</h1>
	<p>Welcome to Spring home page</p>
	
	<p>Visit our great customer <a href="${pageContext.request.contextPath}/customer">Page</a></p>

	<p>
		User:
		<security:authentication property="principal.username" />
	</p>
	<p>
		Role:
		<security:authentication property="principal.authorities" />
	</p>
	<p> Firstname: ${user.firstName }, Lastname: ${user.lastName } </p>

	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${contextPath }/leaders">Leadership meeting(only for
				manager)</a>
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${contextPath }/systems">Systems meeting(only for admin)</a>
		</p>
	</security:authorize>

	<form:form method="POST" action="${contextPath }/logout">
		<input type="submit" value="logout">
	</form:form>
</body>
</html>