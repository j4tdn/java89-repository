<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br/>
		Last name: <form:input path="lastName"/>
		<br/>
		<input type="submit" value="Submit" /> 
		Country:
		<form:select path="country">
			<c:forEach var="countryValue" items="${countries}">
				<form:option value="${countryValue}" label="${countryValue}" />
			</c:forEach>
		</form:select>
		Favorite Language:
		Java: <form:radiobutton path="favoriteLanguage" value="JAVA"/>
		Python: <form:radiobutton path="favoriteLanguage" value="Python"/>
		C#: <form:radiobutton path="favoriteLanguage" value="C#"/>
		<br><br>
		
		Operating Systems:
		MAC OS: <form:checkbox path="operatingSystems" value="MAC OS"/>
		Linux: <form:checkbox path="operatingSystems" value="Linux"/>
		MS Windows: <form:checkbox path="operatingSystems" value="MS Windows"/>
		
	</form:form>
</body>
</html>