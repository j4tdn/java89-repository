<%@ include file="/WEB-INF/taglib/import.jsp"%>
<html>
<body>
	<h2>Spring Home Page -Welcome!</h2>
	<p>Well come to spring home page</p>
	<p>I wish you all the best</p>


	<security:authorize access="!isAuthenticated()">
		<a href="${contextPath}/login">Login</a>
		<a href="${contextPath}/signup">Sign Up</a>
	</security:authorize>
	<security:authorize access="isAuthenticated()">
		<form:form action="${contextPath}/logout" method="POST">
			<input type="submit" value="logout">
		</form:form>
	</security:authorize>
	<security:authorize access="isAuthenticated()">
	Visit our great customer <a href="${contextPath}/customer">page</a>
	</security:authorize>

	<security:authorize>

		<p>
			User:
			<security:authentication property="principal.username" />
		</p>
		<p>
			Role(s):
			<security:authentication property="principal.authorities" />
		</p>
		<p>First Name: ${user.firstName} , Last Name: ${user.lastName}</p>
	</security:authorize>

	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${contextPath}/leaders"> Leadership meeting (Only for
				Manager)</a>
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${contextPath}/systems"> IT systems meeting (Only for
				Admin)</a>
		</p>
	</security:authorize>
</body>
</html>
