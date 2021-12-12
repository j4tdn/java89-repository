<%@ include file="/WEB-INF/taglib/import.jsp"%>
<html>
<head>
<title>Forbidden 403</title>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>
	<h1>Access denied - You have not authorized to access resources</h1>
	<h3>
		Redirect to your home page after <span id="runner">10</span> seconds
	</h3>
	<p>
		<a href="${contextPath}/"> Back to home page</a>
	</p>
	<script>
		let counter = 10;
		let interval = setInterval(() => {
			counter--;
			document.querySelector("#runner").textContent = counter;
			if(counter === 0) {
				window.location.href =  "${contextPath}/";
				clearInterval(interval);
			}
		},1000)
	</script>
</body>
</html>
