<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${dojo.name}"/> Dojo</title>
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
		<div class="nav">
			<h1><c:out value="${dojo.name}"/> Ninjas</h1>
			<a href="/dojos">Back to Dojos</a>
		</div>
		<table class="table table-responsive table-hover">
			<thead>
				<tr class="table-dark">
					<td>First Name</td>
					<td>Last Name</td>
					<td>Age</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ninjas}" var="ninja">
					<tr>
						<td><c:out value="${ninja.firstName}"/></td>
						<td><c:out value="${ninja.lastName}"/></td>
						<td><c:out value="${ninja.age}"/></td>
					</tr>
				</c:forEach>			
			</tbody>
		</table>
	</div>
</body>
</html>