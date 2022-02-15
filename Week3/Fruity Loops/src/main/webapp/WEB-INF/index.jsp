<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>First JSP</title>
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="container">
		<h1>Fruit Store</h1>
		<div class="tableContainer">
		<table>
			<thead>
				<tr>
					<td><h2>Name</h2></td>
					<td><h2>Price</h2></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fruits}" var="fruit">
					<tr>
						<td><c:out value="${fruit.name}"/></td>
						<td><c:out value="${fruit.price}"/></td>
					</tr>
				</c:forEach>
			</tbody>			
		</table>
		</div>
	</div>
</body>
