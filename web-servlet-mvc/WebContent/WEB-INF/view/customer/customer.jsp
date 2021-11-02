<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' />

</head>
<body>
	<h1>Customer-inform</h1>

	First Name: ${customer.firstName}
	<hr>
	Last Name: ${customer.lastName}
	<hr>
	free passes: ${customer.freePasses}
	<hr>
	postal code: ${customer.postalCode}
	<hr>
</body>
</html>