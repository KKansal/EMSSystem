<%@page import="com.to.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
	<a href="/EMSProject/logout"> <button>Logout </button></a><br/>
	<div align="center">
		<a href="/EMSProject/user/viewCompliance"> <button>View Assigned RLs </button></a><br/>
		<a href="/EMSProject/user/updateStatusReports"> <button>Update Comments on Existing RLSs </button></a><br/>
		<a href="/EMSProject/user/viewStatusReports"> <button>View Responded RLs </button></a><br/>
	</div>
</body>
</html>