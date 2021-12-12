<%@ include file="/WEB-INF/taglib/import.jsp"%>
<html>
<head>
<title>Manager Page</title>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- ${pageContext.request.contextPath}/showForm/customer -->
			<!-- return false = event.preventDefault()-->
			<form:form action="${contextPath}/customer/search" method="GET">
			Search Customer : <input type="text" name="param" />
				<input type="submit" value="Search" class="add-buton">
			</form:form>

			<input type="button" value="Add customer"
				onclick="window.location.href='${contextPath}/customer/add'; return false;">
			<table>
				<tr>

					<c:url var="orderByFirstName" value="/customer/orderByFirstName" />
					<c:url var="orderByLastName" value="/customer/orderByLastName" />
					<c:url var="orderByEmail" value="/customer/orderByEmail" />
					<th><a href="${orderByFirstName}">First name</a></th>
					<th><a href="${orderByLastName}">Last name</a></th>
					<th><a href="${orderByEmail}">Email name</a></th>
					<security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
						<th>Action</th>
					</security:authorize>

				</tr>

				<c:forEach var="customer" items="${customers}">

					<!-- create updateLink with customer id -->
					<c:url var="updateLink" value="/customer/update">
						<c:param name="id" value="${customer.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/customer/delete"> //@Requestparam
						<c:param name="id" value="${customer.id}"></c:param>
					</c:url>
					<%-- 	<c:url var="deleteLink" value="/customer/delete/${customer.id}">
						
					</c:url> --%>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
							<td>
								<%-- 	${pageContext.request.contextPath}/customer/showFormForUpdate?=id=${customers.id} --%>
								<security:authorize access="hasRole('MANAGER')">
									<a href="${updateLink}">Update</a>
								</security:authorize> <security:authorize access="hasRole('ADMIN')">
									<a href="${deleteLink}"
										onclick="if(!confirm('Are you sure you want to delete this customer ?')) return false">Delete</a>
								</security:authorize>
							</td>
						</security:authorize>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>
