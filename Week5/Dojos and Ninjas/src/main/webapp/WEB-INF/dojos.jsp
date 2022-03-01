<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dojos</title>
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
		<h1>Dojos</h1>
		<table class="table table-responsive table-hover">
			<tbody>
				<c:forEach items="${dojos}" var="dojo">
					<tr><td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td></tr>
				</c:forEach>			
			</tbody>
		</table>
		<div class="bottomNav">
			<a href="dojos/new">Add a Dojo</a>
			<a href="ninjas/new">Add a Ninja</a>
		</div>
	</div>
</body>
</html>