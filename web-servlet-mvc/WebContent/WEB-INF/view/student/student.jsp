<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="<c:url value='/resources/css/style.css' />">
</head>
<body>
	<h3>${student.firstName} - ${student.lastName} - ${student.country}</h3>
	<h3>Favorite Language: ${student.favoriteLanguage}</h3>
	<h3>Operating Systems</h3>
	<c:forEach var="os" items="${student.operatingSystems}">
		<h3>${os}</h3>
	</c:forEach>
</body>
</html>