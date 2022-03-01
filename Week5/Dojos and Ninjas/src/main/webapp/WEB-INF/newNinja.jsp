<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Ninja</title>
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
			<h1>New Ninja</h1>
			<a href="/dojos">Back to Dojos</a>
		</div>
		<form:form  action='/ninjas/new' method='POST' modelAttribute="ninja">
			<p>
				<form:label path="dojo">Dojo :</form:label>
				<form:errors path="dojo"/>
				<form:select class="form-select" path="dojo">					
					<c:forEach items="${dojos}" var="dojo">
						<option value="${dojo.id}">${dojo.name}</option>
					</c:forEach>				
				</form:select>
			</p>
			<p>
        		<form:label path="firstName">First Name :</form:label>
				<form:errors path="firstName"/>
				<form:input class="form-control" path="firstName"/>
			</p>
			<p>
        		<form:label path="lastName">Last Name :</form:label>
				<form:errors path="lastName"/>
				<form:input class="form-control" path="lastName"/>
			</p>
			<p>
        		<form:label path="age">Age :</form:label>
				<form:errors path="age"/>
				<form:input class="form-control" path="age"/>
			</p>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>