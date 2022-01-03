<%@ include file="/WEB-INF/taglib/import.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>Customer Management Application</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
</head>
<body>
	<header>
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand">Customer Management Application</a>
				<form:form class="d-flex" action="${contextPath}/customer/search" method="GET">
					<input name="keyword" value="${param.keyword}" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form:form>
			</div>
		</nav>
	</header>
	
	
	<main class="container-fluid">
		<a href="${contextPath}/customer/add" class="btn btn-primary btn-sm mt-3 mb-3">
			<i class="far fa-address-book"></i> Add Customer
		</a>

		<table class="table table-bordered table-striped">
			<thead class="table-dark">
			<tr>
				<th><a href="${contextPath}/customer?sort=firstName">First name</a></th>
				<th><a href="${contextPath}/customer?sort=lastName">Last name</a></th>
				<th><a href="${contextPath}/customer?sort=email">Email name</a></th>
				<th>Action</th>
			</tr>
			</thead>

			<tbody>
			<c:forEach var="customer" items="${customers}">
				<c:url var="updateLink" value="/customer/update">
					<c:param name="id" value="${customer.id}"></c:param>
				</c:url>

				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="id" value="${customer.id}"></c:param>
				</c:url>

				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td>
						<a class="btn btn-info btn-sm" href="${updateLink}">Update</a>
						<a class="btn btn-danger btn-sm" href="${deleteLink}" 
						onclick="if(!confirm('Are you sure you want to delete this customer ?')) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<c:if test="${totalPages > 1}">
			<nav class="float-end">
				<ul class="pagination">
					<c:if test="${currentPage != 1}">
						<li class="page-item">
							<a href="${contextPath}/customer?page=${currentPage-1}" aria-label="Previous" class="page-link" > 
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					
					<c:forEach var="page" begin="1" end="${totalPages}">
						
						<li class="page-item page-toggle">
						<c:choose>
							<c:when test="${page == currentPage}">
								<a class="page-link bg-warning" href="${contextPath}/customer?page=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="${contextPath}/customer?page=${page}">${page}</a>
							</c:otherwise>
						</c:choose>
						</li>
						
					</c:forEach>
					
					<c:if test="${currentPage != totalPages}">
						<li class="page-item">
							<a href="${contextPath}/customer?page=${currentPage+1}" aria-label="Next" class="page-link" > 
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
				</ul>
			</nav>
		</c:if>
	</main>

	<footer class="bg-light fixed-bottom py-3 text-center">
		<div class="container-fluid">
			<span class="text-muted">CMA made with JAVA89  &#129392;  03.01.2022</span>
		</div>
	</footer>
</body>
</html>