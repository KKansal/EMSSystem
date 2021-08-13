<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Department</title>
</head>
<body>
	<div align="center">
	<form action="addDepartment" method="POST">
		<label> Department Name </label><br/>
		<input type="text" name="deptName" />
		<button type="submit"> Submit</button>
	</form>
	</div>

<p style="color:${color};" > ${message} </p>
</body>
</html>