<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book Share</title>
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
			<h1>Change your entry</h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<div class="formContainer">
			<form:form action="/books/${editedBook.id}/edit" method='POST' modelAttribute="book">
				<input type="hidden" name="_method" value="put">
				<form:hidden path="user" value="${ user.id }"/>
				<div class="formGroup">
					<form:label path="title">Title:</form:label>
					<form:errors path="title" class="text-danger"/>
					<form:input path="title" class="bootOverride form-control" value="${ editedBook.title }"/>
	        	</div>
	        	<div class="formGroup">
					<form:label path="author">Author:</form:label>
					<form:errors path="author" class="text-danger"/>
					<form:input path="author" class="bootOverride form-control"  value="${ editedBook.author }"/>
	        	</div>
	        	<div class="formGroup">
					<form:label path="thoughts">Thoughts:</form:label>
					<form:errors path="thoughts" class="text-danger"/>
					<form:input path="thoughts" class="bootOverride form-control" value="${ editedBook.thoughts }"/>
	        	</div>
	        	<input class ="formButton" type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>