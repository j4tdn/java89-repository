<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />'/>

</head>
<body>
	<h1>student-inform</h1>
		
	<h3>${student.firstName} - ${student.lastName} </h3>
	
	<h3>Country: ${student.country} </h3>
	
	<h3>Favorite Language: ${student.favoriteLanguage}</h3>
	
	Operating Systems:
	<c:forEach var="os" items="${student.operatingSystems}">
		<h3>${os}</h3>
	</c:forEach>
</body>
</html>