<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>

</head>
<body>
	<h2>CUSTOMER RELATION MANAGER</h2>
	<br><br>
	<input type="button" value="Add Customer" onclick="window.location.href='add';" ><br>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<br>
		<c:forEach var="temp" items="${theCustomer}">
			<c:url var="updateLink" value="/customer/update">
				<c:param name="customerId" value="${temp.id}" />
			</c:url>
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${temp.id}" />
			</c:url>
		<tr>
			<td>${temp.firstName}</td>
			<td>${temp.middleName}</td>
			<td>${temp.lastName}</td>
			<td>${temp.email}</td>
			<td><a href="${updateLink}">Update</a> | 
			<a href="${deleteLink}" 
			onclick="if(!(confirm('Are you sure you want to delete'))) return false;">Delete</a> </td>
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>