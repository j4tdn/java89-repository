<%@ include file="/WEB-INF/tag-lib/import.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forbidden</title>
</head>
<body>
	
	<h3>Access denied - You have not authorized to access this resource</h3>
	<hr>
	<p>Redirect to home page after <span id="runner">10</span>s</p>
	<p>
		<a href="${ contextPath }/home">Back to home page</a>
	</p>
	
	<script type="text/javascript">
		let counter = 10;
		let interval = setInterval(() => {
			counter--;
			document.querySelector("#runner").textContent = counter;
			if (counter === 0) {
				window.location.href = "${contextPath}/";
				clearInterval(interval);
			}
		}, 1000);
	</script>
</body>
</html>