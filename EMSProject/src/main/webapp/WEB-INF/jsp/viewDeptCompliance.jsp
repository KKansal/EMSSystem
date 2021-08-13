<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Compliance for Department</title>
</head>
<body>
<div align="center">
<table>
	<tr>
		<th> RL Id </th>
		<th> RL Type </th>
		<th> Description</th>
		<th> Creation Date </th>
		<th> Department </th>
	</tr>
	
	<c:forEach items="${complianceList}" var="compliance">
    	<tr>      
	        <td>${compliance.getComplianceId()}</td>
	        <td>${compliance.getRlType()}</td>
	        <td>${compliance.getDetails()}</td>
	        <td>${compliance.getCreateDate() }</td>
	        <td>${compliance.getDepartment().getDepartmentName()}</td>
    	</tr>
	</c:forEach>

</table>
</div>

</body>
</html>