<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Read Share</title>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="topBar">
			<h1>Welcome, <c:out value="${user.name}" /></h1>
			<a href="/logout">logout</a>
		</div>
		<div class="topBar">
			<p>Books from everyone's shelves:</p>
			<a href="/books/new">+ Add a book to my shelf</a>
		</div>
		
		<table class="table table-responsive table-hover">
			<thead>
				<tr class="table-dark">
					<td>ID</td>
					<td>Title</td>
					<td>Author Name</td>
					<td>Posted By</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.author}"/></td>
						<td><c:out value="${book.user.name}"/></td>
					</tr>
				</c:forEach>			
			</tbody>
		</table>
		
	</div>
</body>
</html>