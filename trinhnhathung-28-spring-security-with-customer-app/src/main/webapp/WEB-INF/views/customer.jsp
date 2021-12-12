<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/style.css">
<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>CRM</h1>
	<br>

	<security:authorize access="hasAnyRole('MANAGER','ADMIN')">
		<a class="btn bg-primary" href="${pageContext.request.contextPath}/addCustomer">Add customer</a>
	</security:authorize>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email Name</th>
				<security:authorize access="hasAnyRole('MANAGER','ADMIN')">
					<th scope="col">Action</th>
				</security:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers }" var="customer">
				<tr>
					<td>${customer.lastName }</td>
					<td>${customer.lastName }</td>
					<td>${customer.email }</td>
					<security:authorize access="hasRole('MANAGER')">
						<td>
							<button class="btn btn-primary">Update</button>
						</td>
					</security:authorize>

					<security:authorize access="hasRole('ADMIN')">
						<td>
							<button class="btn btn-primary">Update</button>
							<button class="btn btn-danger">Delete</button>
						</td>
					</security:authorize>
				</tr>
			</c:forEach>


		</tbody>
	</table>
</body>
</html>