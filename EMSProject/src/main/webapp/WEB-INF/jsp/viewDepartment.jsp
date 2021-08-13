<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Departments</title>
</head>
<body>
<div align="center">
<table >
	
	<tr>
		<th> Department Id </th>
		<th> Department Name </th>
	</tr>
	
	<c:forEach items="${departmentList}" var="department">
    	<tr>      
        <td>${department.getDepartmentId()}</td>
        <td>${department.getDepartmentName()}</td>  
    	</tr>
	</c:forEach>
</table>
</div>

</body>
</html>