<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
	<div align="center">
	<form action="deleteEmployee" method="POST">
		<label> Employee Id</label> <br/>
		<input name="empId" type="number" /> <br/>	
		<button type="submit"> Submit </button>
	</form>
	</div>
<p style="color:${color};" > ${message} </p>
</body>
</html>