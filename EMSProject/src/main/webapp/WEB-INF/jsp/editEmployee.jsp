<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditEmployee</title>
</head>
<body>
	<div align="center">
	<form action="editEmployee" method="POST">
		<label> Employee Id</label> <br/>
		<input name="empId" type="number" /> <br/>
		<label> First Name </label> <br/>
		<input name="fname" type="text" /> <br/>
		<label> Last Name </label> <br/>
		<input name="lname" type="text" /> <br/>
		<label> Date of Birth </label> <br/>
		<input name="date" type="date" /> <br/>
		<label> Email </label> <br/>
		<input name="email" type="text" /> <br/>
		<label> Department </label> <br/>
		<input name="department" type="number" /> <br/>
		<button type="submit"> Submit </button>
	
	
	</form>
</div>
<p style="color:${color};" > ${message} </p>
</body>
</html>