<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Travel Expenses</title>
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
		<%-- Show all Expenses --%>
		<h1>Save Travels</h1>
		<table class="table table-responsive table-hover">
			<thead>
				<tr class="table-dark">
					<td>Name</td>
					<td>Vendor</td>
					<td>Amount</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${expenses}" var="expense">
					<tr>
						<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
						<td><c:out value="${expense.vendor}"/></td>
						<td><c:out value="${expense.price}"/></td>
						<td class="action">
							<a href="/expenses/${expense.id}/edit">Edit</a>
							<form  action='/expenses/${expense.id}/delete' method='POST'>
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>			
			</tbody>
		</table>
		<%-- New Expense Form --%>
		<h2>Add an Expense</h2>
		<form:form  action='/expenses/new' method='POST' modelAttribute="expense">
        	<p>
        		<form:label path="name">Name: </form:label>
				<form:errors path="name"/>
				<form:input class="form-control" path="name"/>
			</p>
			<p>
				<form:label path="vendor">Vendor: </form:label>
				<form:errors path="vendor"/>
				<form:input class="form-control" path="vendor"/>
			</p>
			<p>
				<form:label path='amount'>Amount: </form:label>
				<form:errors path='amount'/>
				<form:input class="form-control" path='amount'/>
			</p>
			<p>
				<form:label path="description">Description: </form:label>
				<form:errors path="description"/>
				<form:textarea class="form-control" path="description" rows="4" cols="50"/>
			</p>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>