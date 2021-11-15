<%@ include file="/WEB-INF/taglib/import.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<%--
		${param.searchName} =>> <%request.getParameter('searchName')>
		model.addAttribute('key', value) =>> ${key} || <c:out value=${key} />
	--%>
	
	<div id="container">
		<div id="content">
			<!--  add a search box -->
            <form:form action="${contextPath}/customer/search" method="GET">
            <!-- ${empty param.searchName ? '' : param.searchName} = ${fn:trim(param.searchName)} -->
                Search customer: <input type="text" name="searchName" value="${fn:trim(param.searchName)}"/>
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>

			<!-- add a new button-->
			<!-- <a href="${contextPath}/customer/add">Add customer</a>  -->
			<input type="button" value="Add Customer" class="add-button"
				   onclick="window.location.href='${contextPath}/customer/add'; return false;"
			/>


			<!--  add our html table here -->
			<c:url var="orderByFirstName" value="/customer/orderByFirstName"></c:url>
			<c:url var="orderByLastName" value="/customer/orderByLastName"></c:url>
			<c:url var="orderByEmail" value="/customer/orderByEmail"></c:url>
			<table>
				<tr>
					<th><a href="${orderByFirstName}">First Name</a></th>
					<th><a href="${orderByLastName}">Last Name</a></th>
					<th><a href="${orderByEmail}">Email Name</a></th>
					<th>Action</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="customer" items="${customers}">
					<!-- construct an "update" link with customer id -->
					<!-- Using @PathVariable
					<c:url var="updateLink" value="/customer/update/${customer.id}">
					</c:url>
					 -->
					
					<!-- Using @RequestParam -->
					<c:url var="updateLink" value="/customer/update">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>					
					
					<tr>
						<td> ${customer.firstName} </td>
						<td> ${customer.lastName} </td>
						<td> ${customer.email} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>









