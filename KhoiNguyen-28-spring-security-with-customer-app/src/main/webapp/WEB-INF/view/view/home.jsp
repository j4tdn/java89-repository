<%@include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>
	<h2>spring home page - welcome</h2>
	<hr>
	<p>welcome spring home  page</p>
	<hr>
	<!-- Show User ID and Roles -->
	
	<p> User: <security:authentication property="principal.username"/> </p>
	<p> Role(s): <security:authentication property="principal.authorities"/> </p>
	<hr>
	<security:authorize access="hashRole('MANAGER')">
	<p>
	<a href="${ContextPath}/leaders">Leadership meeting</a> (Only for manager)
	</p>
	</security:authorize>
	<security:authorize access="hashRole('ADMIN')">
	<p>
	<a href="${ContextPath}/systems">IT system meeting</a> (Only for Admin
	</p>
	</security:authorize>
	<form:form method="POST" action="${contextPath}/logout">
		<input type="submit" value="logout">
	</form:form>
</body>
</html>