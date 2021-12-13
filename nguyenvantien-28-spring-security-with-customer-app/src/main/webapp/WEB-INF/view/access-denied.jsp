<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/taglib/import.jsp"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Spring Security Home Page</title>
<link rel="stylesheet" type="text/css" href="css/demo.css">
</head>
<body>
	<h2>Forbidden</h2>
	<hr>
	
	<h3>Redirect to your page after <span id="runner"> 10</span> seconds </h3>

	<hr>

	<h3>Access denied</h3>
	<p>
		<a href="${contextPath}/home">Back to Home Page</a>
	</p>
	
	<script>
		let counter = 10;
		let interval = setInterval(() => {
			counter --;
			document.querySelector('#runner').textContent = counter
			if(counter === 0){
				window.location.href = `${contextPath}/`
				clearInterval(interval)
			}
		}, 1000);
	</script>

</body>

</html>