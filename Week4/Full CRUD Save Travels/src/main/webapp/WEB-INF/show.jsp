<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show Expense</title>
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
			<h1>Expense Details</h1>
			<a href="/expenses">Go Back</a>
		</div>
		<table class="table table-responsive table-hover">
			<tr>
				<td>Expense Name :</td>
				<td><c:out value="${expense.name}"/></td>
			</tr>
			<tr>
				<td>Expense Description : </td>
				<td><c:out value="${expense.description}"/></td>
				
			</tr>
			<tr>
				<td>Vendor : </td>
				<td><c:out value="${expense.vendor}"/></td>
			</tr>
			<tr>
				<td>Amount Spent : </td>
				<td><c:out value="${expense.price}"/></td>
			</tr>
		</table>
	</div>
</body>
</html>