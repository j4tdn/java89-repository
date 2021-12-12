<%@ include file="/WEB-INF/tag-lib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Page</title>
<link rel="stylesheet" type="text/css" href="${ contextPath }/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<form:form action="${contextPath}/customer/search" method="GET">
				Search customer: <input type="text" name="q" value="${param.q}">
				<input type="submit" value="Search" class="add-button">
			</form:form>
		
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
				<input type="button" value="Add customer" class="add-button"
					onclick="window.location.href='${pageContext.request.contextPath}/customer/add'; return false;">
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
						<td>${ customer.firstName }</td>
						<td>${ customer.lastName }</td>
						<td>${ customer.email }</td>
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
							<td>
									<a href="${ updateLink }">Update</a>
								
								<span> | </span>
								
								<security:authorize access="hasRole('ADMIN')">
									<a href="${ deleteLink }"
									onclick="if (!confirm('Are u sure?')) return false;">Delete</a>
								</security:authorize>
								
							</td>
						</security:authorize>
					</tr>
				</c:forEach>
				<tr>

				</tr>
			</table>
			
		<p><a href="${contextPath}/home">Back to home page</a></p>
		</div>
	</div>

</body>
</html>