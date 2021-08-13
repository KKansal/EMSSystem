<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Compliance</title>
</head>
<body>
<div align="center">
	<form action="addCompliance" method="POST">
		<label> RL Type </label> <br/>
		<input name="rltype" type="text" /> <br/>
		<label> RL Details </label> <br/>
		<input name="rldetails" type="text" /> <br/>
		<label> Department </label> <br/>
		<input name="department" type="number" /> <br/>
		<button type="submit"> Submit </button>
	
	
	</form>
</div>
<p style="color:${color};" > ${message} </p>
</body>
</html>