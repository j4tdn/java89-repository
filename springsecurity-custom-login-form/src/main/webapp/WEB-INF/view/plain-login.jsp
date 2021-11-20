<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>

<head>
	<title>Custom Login Page</title>
	<link rel="stylesheet" type="text/css" href="css/demo.css">
    
	<!-- <style>
		.failed {
			color: red;
		}
	</style> -->
	
</head>

<body>

<h3>My Custom Login Page</h3>

	<form:form action="${pageContext.request.contextPath}/authenticate"
			   method="POST">
	
		<!-- Check for login error -->
	
		<c:if test="${param.error != null}">
			<i class="failed">Sorry! You entered invalid username/password.</i>
			
		</c:if>
			
		<p>
			User name X: <input type="text" name="username" />
		</p>

		<p>
			Password X: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
		
	</form:form>

</body>

</html>












