<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer-Form</title>

<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />'/>
</head>
<body>

	<form:form action="processForm" modelAttribute="customer">
		First name: <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error"></form:errors>
		<br>
		<br>
		Last name: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"></form:errors>

		<br>
		<br>
		Free Passes: <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"></form:errors>
		<br>
		<br>
		postal code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"></form:errors>

		<input type="submit" value="submit" />

	</form:form>
</body>
</html>