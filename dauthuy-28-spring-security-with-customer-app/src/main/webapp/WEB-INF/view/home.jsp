<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Security</title>
</head>
<body>
	<h2>HoangDang Company Home Page</h2>
	Welcome to the HoangDang company home page !!! <br><br>
	<hr>
	User: <security:authentication property="principal.username"/> <br>
	Role(s): <security:authentication property="principal.authorities"/> <br>
	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to /leaders ... this is for the managers -->
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		(Only for Manager peeps)
		<hr>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to /systems ... this is for the admins -->
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		(Only for System peeps)
		<hr>
	</security:authorize>
	<!-- Add a logout form -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>