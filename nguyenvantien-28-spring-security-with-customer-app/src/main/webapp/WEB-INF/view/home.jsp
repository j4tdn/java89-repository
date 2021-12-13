<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/taglib/import.jsp"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<body>
	<h2>Spring Security Home Page</h2>
	<hr>

	<p>Welcome to the spring company home page!</p> <hr>
	
	Visit our great customer <a href="customer" style="color: blue;">page</a> <hr>

	<p>
		User:
		<security:authentication property="principal.username" />
	</p>
	<p>
		Role(s)
		<security:authentication property="principal.authorities" />
	</p>
	
	<p>
		FirstName: ${user.firstName}, LastName: ${user.lastName}
	</p>

	<hr>

	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${contextPath}/leaders">Leadership meeting</a>(Only for
			manager)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>
		<a href="${contextPath}/systems">IT Systems meeting</a>(Only for
		Admin)
	</p>
	</security:authorize>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>