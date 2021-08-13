<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Comments on Compliance</title>
</head>
<body>

<div align="center">
<form action="updateStatusReports" method="POST">
	<label>
		RL Id 
	</label>
	<br />
	<input type="number" name ="compliance"/><br/>
	<textarea name="comments">
		Enter Comments
	</textarea><br/>

	<button type="submit"> Update Comments</button>
	
</form>
</div>

<p style="color:${color};" > ${message} </p>

</body>
</html>