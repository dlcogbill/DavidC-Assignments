<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Dojo</title>
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
			<h1>New Dojo</h1>
			<a href="/dojos">Back to Dojos</a>
		</div>
		<form:form  action='/dojos/new' method='POST' modelAttribute="dojo">
        	<p>
        		<form:label path="name">Name :</form:label>
				<form:errors path="name"/>
				<form:input class="form-control" path="name"/>
			</p>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>