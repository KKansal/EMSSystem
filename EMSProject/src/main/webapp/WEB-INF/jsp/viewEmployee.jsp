<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Employees</title>
</head>
<body>
<div align="center">
<table>
	<tr>
		<th> Employee Id </th>
		<th> First Name </th>
		<th> Last Name </th>
		<th> Email </th>
		<th> DOB </th>
		<th> Department </th>
	</tr>
	
	<c:forEach items="${employeeList}" var="employee">
    	<tr>      
        <td>${employee.getEmpId()}</td>
        <td>${employee.getFirstName()}</td>
        <td>${employee.getLastName()}</td>
        <td>${employee.getEmailId()}</td>
        <td>${employee.getDOB()}</td>
        <td>${employee.getDepartment().getDepartmentId()}  
    	</tr>
	</c:forEach>

</table>
</div>
</body>
</html>