<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Welcome</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div>
		
		<h1 class="text-success">Spring Home Page - Welcome</h1>
		<hr>
		<p>Welocm to Spring Honme Page</p>
		<p>I wish You all the best</p>
		<hr>
		

		<div class="d-flex">
			<div>
				<a href="showMyLoginPage" 
					class="btn btn-success" role="button" aria-pressed="true">
					Login
				</a>
			</div>
			
<!-- Register button -->
			<div>
				<a href="/register/showRegistrationForm" 
					class="btn btn-primary" role="button" aria-pressed="true">
					Sign up
				</a>
			</div>

		</div>

	</div>

</body>
</html>