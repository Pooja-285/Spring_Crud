<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD CUSTOMER</title>

</head>
<body>
<h2>CUSTOMER RELATION MANAGER</h2>
<br><br>

<p><a href="${pageContext.request.contextPath}/customer/list">Customer List</a></p>
<br>
<form:form action= "save" modelAttribute="theCustomer" method ="post">

<!-- to associate this from with id -->
	<form:hidden path="id"/>
	
	<fieldset>
		<legend><h3> ADD CUSTOMER </h3></legend>
		<p>First Name : <form:input path="firstName" /></p>
		<p>Middle Name : <form:input path="middleName" /></p>
		<p>Last Name : <form:input path="lastName" /></p>
		<p>Email id : <form:input path="email" /></p><br>
		<input type="submit" value ="SUBMIT"> 
	</fieldset>
</form:form>

</body>
</html>