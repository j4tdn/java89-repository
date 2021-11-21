<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- return false = event.preventDefault() -->
			<input type="button" value="Add Customer" class="add-button"
				onclick="window.location.href='customer/add'; return false;" />
			<div>
				
				<form action="${contextPath}/customer/find">
					<span>Search Customer: </span>
					<input name="value" type="text" value="${param.value}">
					<input type="submit"
						value="Search" class="add-button"
					/>
				</form>
			</div>

			<c:url var="sortLastName" value="/customer/sort">
				<c:param name="sorting" value="firstName"></c:param>
			</c:url>
			<c:url var="sortFirstName" value="/customer/sort">
				<c:param name="sorting" value="lastName"></c:param>
			</c:url>
			<c:url var="sortEmail" value="/customer/sort">
				<c:param name="sorting" value="email"></c:param>
			</c:url>
				
			<table>
			
				<c:url var="orderByFirstName" value="/customer/orderByFirstName"></c:url>
				<c:url var="orderByLastName" value="/customer/orderByLastName"></c:url>
				<c:url var="orderByEmail" value="/customer/orderByEmail"></c:url>
				<tr>
					<th><a href="${orderByFirstName}">First name</a></th>
					<th><a href="${orderByLastName}">Last name</a></th>
					<th><a href="${orderByEmail}">Email</a></th>
					<th>Action</th>
				</tr>

				<c:forEach var="customer" items="${customers}">

					<!-- create updateLink with customer id -->
					<c:url var="updateLink" value="/customer/update">
						<c:param name="id" value="${customer.id}"></c:param>
					</c:url>

					<!-- create deleteLink with customer id >> @requestParam -->
					<%-- <c:url var="deleteLink" value="/customer/delete">
						<c:param name="id" value="${customer.id}"></c:param>
					</c:url> --%>
					<c:url var="deleteLink" value="/customer/delete/${customer.id}">
					</c:url>

					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!confirm('Are you sure you want to delete this customer ?')) return false"
							>Delete</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

	<%-- <c:forEach items="${customers }" var="customer">
		<p>${customer.firstName }</p>
	</c:forEach> --%>
</body>
</html>