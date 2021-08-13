<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Compliance</title>
</head>
<body>
<div align="center">
<table>
	<tr>
		<th> RL Id </th>
		<th> RL Type </th>
		<th> RL Details </th>
		<th> Creation Date</th>
		<th> Department Name </th>
		<th> Status </th>
		
	</tr>
	
	<c:forEach items="${complianceList}" var="compliance" varStatus="status">
		<tr>      
	        <td>${compliance.getComplianceId()}</td>
	        <td>${compliance.getRlType()}</td>
	        <td>${compliance.getDetails()}</td>
	        <td>${compliance.getCreateDate() }</td>
	        <td>${compliance.getDepartment().getDepartmentName()}</td>
	        <td>${statusList[status.index]}</td>
	
    	</tr>
	</c:forEach>

</table>
</div>
</body>
</html>