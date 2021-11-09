<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  --%>
<%@include file="/WEB-INF/taglib/import.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer-form</title>
<link rel="stylesheet" 
	  type="text/css" 
	  href="${contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
	<div id= "wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="save" modelAttribute="customer" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td> <label>First name:</label> </td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td> <label>Last name:</label> </td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td> <label>Email:</label> </td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td> <label></label> </td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>		
</body>
</html>