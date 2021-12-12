<%@ include file="/WEB-INF/taglib/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer - Form</title>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="container">
		<h3>Save form</h3>
		<form:form action="save" modelAttribute="customer" method="POST">
		<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label> First name : </label>
						<td> <form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label> Last name : </label>
						<td> <form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label> Email : </label>
						<td> <form:input path="email"/></td>
					</tr>
					
					<tr>
						<td><label> Email : </label>
						<td><input type="submit" value="Save" class="save"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>