<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student-Form</title>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br> <br>
		Last name: <form:input path="lastName"/>
		<input type="submit" value="submit" />
		Country : <form:select path="country">
			<c:forEach var="countryValue" items="${countries}">
				<form:option value="${countryValue}" label="${countryValue}"></form:option>	
			</c:forEach>
				 </form:select> 
				 <br> <br>
		Favorite language:
		Java: <form:radiobutton path="favoriteLanguage" value="JAVA"/>		 
		Python: <form:radiobutton path="favoriteLanguage" value="Python"/>		 
		C#: <form:radiobutton path="favoriteLanguage" value="C#"/>		 
				 
		<br> <br>
		
		<h3>Operating Systems:</h3> 
		Mac OS: <form:checkbox path="operatingSystems" value="Mac OS"/>
		Linus : <form:checkbox path="operatingSystems" value="Linus"/>
		MS Windows: <form:checkbox path="operatingSystems" value="MS Windows"/>		
		<br> <br>
		 
		<input type="submit" value="submit" />
	
	</form:form>
</body>
</html>