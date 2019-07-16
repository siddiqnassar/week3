<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<h1>Displaying all employees</h1>
<h3>
 
<table border="1">
	<tr>
		<th>Employee</th>
		<th>Name</th>
	</tr>
	
	<c:forEach items="${empList}" var="employee">
		<tr>
			<td>${employee.id }</td>
			<td>${employee.name }</td>
		</tr>
	</c:forEach>
</table>
</h3>
</body>
</html>