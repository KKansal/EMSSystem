<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Log In Page</title>
</head>
<body>
	<div align="center">
		<form action="home" method="POST">
			<label> UserId </label> <br/>
			<input type="text" name="userId" /> <br/>
			<label> Password </label> <br/>
			<input type="password" name="password" /> <br/>
			<button type="submit"> Log In</button>
			<p style="color:${color}"> ${message}</p>
		</form>
	</div>


</body>
</html>