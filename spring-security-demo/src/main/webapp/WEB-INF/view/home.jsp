<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/taglib/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<body>
	<h2>Home Page</h2>
	
	<form:form method="POST" action="${contextPath}/logout">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>