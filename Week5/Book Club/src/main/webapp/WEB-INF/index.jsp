<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<h1>Book Club</h1>
		<p>A place for friends to share thoughts on books</p>
		<div class="formContainer">
			
			<form:form  action='/register' method='POST' modelAttribute="newUser">
			<h2>Register</h2>
			
			<form:errors path="name" class="text-danger"/>
			<form:errors path="email" class="text-danger"/>
			<form:errors path="password" class="text-danger"/>
			<form:errors path="confirm" class="text-danger"/>
	        		        
			<div class="formGroup">
				<form:label path="name">Name:</form:label>
				<form:input path="name" class="bootOverride form-control"/>
	        </div>
	        <div class="formGroup">
				<form:label path="email">Email:</form:label>
				<form:input path="email" class="bootOverride form-control"/>
	        </div>
	        <div class="formGroup">
	        	<form:label path="password">Password:</form:label>
	        	<form:password path="password" class="bootOverride form-control"/>
	        </div>
	        <div class="formGroup">
	        	<form:label path="confirm">Confirm PW:</form:label>
	        	<form:password path="confirm" class="bootOverride form-control"/>
        	</div>
        	<input class ="formButton" type="submit" value="Register!"/>
			</form:form>
			
			<form:form  action='/login' method='POST' modelAttribute="newLogin">
				<h2>Log in</h2>
				
				<form:errors path="email" class="text-danger"/>
	        	<form:errors path="password"  class="text-danger"/>
	        	
	        	<div class="formGroup">
					<form:label path="email">Email:</form:label>
					<form:input path="email" class="bootOverride form-control"/>
	        	</div>
	        	<div class="formGroup">
	        		<form:label path="password">Password:</form:label>
	        		<form:password path="password" class="bootOverride form-control"/>
	        	</div>
	        	<input class ="formButton" type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>