<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Your Reports</title>
</head>
<body>
<div align="center">
<table>
	<tr>
		<th> Report Id </th>
		<th> Creation Date</th>
		<th> Comments </th>
		<th> Compliance Id </th>
		<th> Department Name </th> 
	</tr>
	
	<c:forEach items="${reportList}" var="report">
    	<tr>      
        <td>${report.getStatusRpId()}</td>
        <td>${report.getCreateDate()}</td> 
        <td>${report.getComments()} </td>
        <td>${report.getCompliance().getComplianceId()} </td>
        <td>${report.getDepartment().getDepartmentName()}</td>
    	</tr>
	</c:forEach>

</table>
</div>
</html>