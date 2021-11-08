<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Page</title>
<link rel="stylesheet" 
	  type="text/css" 
	  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id= "wrapper">
		<div id="header">
			<h2>CRM - Customer RelationShip Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		<!-- "${pageContext.request.contextPath}/customer/showform"  -->
		<input type="button" value="Add Customer" 
		class="add-button" onclick="window.location.href='showFormForAdd';return false;"
		> <br> <br>
		
			<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Name</th>
			<th>Action</th>
		</tr>
		
			<c:forEach var="customer" items="${customers}">
				<!-- create update link with customer id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="id" value="${customer.id}"></c:param>
				</c:url>
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="id" value="${custome.id}"></c:param>
				</c:url>
				
			<tr>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td>
					<a href="${updateLink}">Update</a>
					|
					<a href="${deleteLink}">Delete</a>
				</td>
					
			</tr>
			</c:forEach>
		
	</table>	
		</div>
		
	</div>

</body>
</html>