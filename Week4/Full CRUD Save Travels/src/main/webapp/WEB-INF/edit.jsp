<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit Expense</title>
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
			<h1>Edit Expense</h1>
			<a href="/expenses">Go Back</a>
		</div>
		<form:form  action='/expenses/${expense.id}/edit' method='POST' modelAttribute="expense">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:hidden path="id" value="${expense.id}"></form:hidden>
        		<form:label path="name">Name: </form:label>
				<form:errors path="name"/>
				<form:input class="form-control" path="name" value="${expense.name}"/>
			</p>
			<p>
				<form:label path="vendor">Vendor: </form:label>
				<form:errors path="vendor"/>
				<form:input class="form-control" path="vendor" value="${expense.vendor}"/>
			</p>
			<p>
				<form:label path='amount'>Amount: </form:label>
				<form:errors path='amount'/>
				<form:input class="form-control" path='amount' value="${expense.amount}"/>
			</p>
			<p>
				<form:label path="description">Description: </form:label>
				<form:errors path="description"/>
				<form:textarea class="form-control" path="description" rows="4" cols="50" value="${expense.description}"/>
			</p>
			<input type="submit" value="Submit">
		</form:form>
	</div>
</body>
</html>