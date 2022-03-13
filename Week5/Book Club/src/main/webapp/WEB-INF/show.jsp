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
			<h1><c:out value="${book.title}" /></h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<h3>
			<c:choose>
				<c:when test = "${book.user.id == user.id}">You</c:when>
				<c:otherwise><c:out value="${book.user.name}" /></c:otherwise>
			</c:choose> read <c:out value="${book.title}" /> by <c:out value="${book.author}" />.
		</h3>
		<h3>Here are 
			<c:choose>
				<c:when test = "${book.user.id == user.id}">your</c:when>
				<c:otherwise><c:out value="${book.user.name}" />'s</c:otherwise>
			</c:choose> thoughts:
		</h3>
		<div>
			<hr>
			<p><c:out value="${book.thoughts}" /></p>
			<hr>
		</div>
		<c:if test = "${book.user.id == user.id}">
			<a href="/books/${book.id}/edit" class="btn btn-primary formButton">Edit</a>
        </c:if>
	</div>
</body>
</html>