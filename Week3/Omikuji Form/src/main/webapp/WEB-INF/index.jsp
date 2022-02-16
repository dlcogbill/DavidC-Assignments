<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Omikuji</title>
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji</h1>
		<form class="formContainer" action="/omikuji/show" method="POST">
			<div>
				<label>Pick any number from 5 to 25:</label>
				<input type="number" name="number" min="5" max="25">
			</div>
			<div>
				<label>Enter the name of any city:</label>
				<input type="text" name="city">
			</div>
			<div>
				<label>Enter the name of any real person:</label>
				<input type="text" name="person">
			</div>
			<div>
				<label>Enter professional endeavor or hobby:</label>
				<input type="text" name="hobby">
			</div>
			<div>
				<label>Enter any type of living thing:</label>
				<input type="text" name="thing">
			</div>
			<div>
				<label>Say something nice to someone:</label>
				<textarea name="message" rows="10" cols="30"></textarea>
			</div>
			<em>Send and show a friend</em>
			<input class="submit" type="submit" value="Send">
		</form>
	</div>
</body>
</html>