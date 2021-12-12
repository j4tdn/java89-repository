<%@include file="/WEB-INF/taglib/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>forbiidden 403</title>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>
	<h3>access-denied - you have not arthorized to access this
		resuource</h3>
	<h3> redirect to  your home page after <span id="runner">10</span> seconds</h3>
	<hr>

	<p>
		<a href="${contextPath}/"> BACK TO HOME PAGE</a>
	</p> 
	
	<script> 
	let counter =10;
		let interval = setInterval(() => {
			counter--;
			document.querySelector("#runner").textContent = counter;
			if(counter == 0){
				window.location.href = "${contextPath}/";	
				clearInterval(interval)
			}
		}, 1000);
	</script>
</body>
</html>