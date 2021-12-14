<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Page</title>
</head>
<body>
	<h2>CRM - Customer Relationship Manager</h2>
	
	<form:form action="${contextPath}/customer/search" method="GET">
		Search customer: <input type="text" name="nameCustomer" value="${param.nameCustomer}">
		<input type="submit" value="Search" class="search-button">
	</form:form>
	
	<security:authorize access="hasAnyRole('MANAGER','ADMIN')">
		<a class="btn bg-primary" href="${pageContext.request.contextPath}/customer/add">Add customer</a>
	</security:authorize>
	
	<table>
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
				<th>Action</th>
			</security:authorize>
		</tr>

		<c:forEach var="customer" items="${ customers }">
			<c:url var="updateLink" value="/customer/update">
				<c:param name="id" value="${ customer.id }"></c:param>
			</c:url>
			
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="id" value="${ customer.id }"></c:param>
			</c:url>
			
			<tr>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
					<td>
						<a href="${pageContext.request.contextPath}/customer/update">Update</a>
						
						<span> | </span>
						
						<security:authorize access="hasRole('ADMIN')">
							<a href="${pageContext.request.contextPath}/customer/delete">Delete</a>
						</security:authorize>
					</td>
				</security:authorize>
			</tr>
		</c:forEach>
	</table>
	<p><a href="${contextPath}/home">Back to home page</a></p>

</body>
</html>