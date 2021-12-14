<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<h2>Spring Home Page - Welcome</h2>
	<hr>
	
	<p>
	Welcome to Spring Home Page
	</p>
	
	<p>I wish you all the best</p>
	
	<form action="${pageContext.request.contextPath}/showMyLoginPage" 
						  method="POST" class="form-horizontal">
		<button type="submit" class="btn btn-success">Login</button>
	</form>
	
	<form action="${pageContext.request.contextPath}/register/showRegistrationForm" 
						  method="POST" class="form-horizontal">
		<button type="submit" class="btn btn-success">Sign up</button>
	</form>
	
	
</body>
</html>