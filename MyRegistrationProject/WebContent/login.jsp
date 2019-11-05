<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Login Page</title>
</head>
<body style="background-color: purple;">
	<form action="LoginRegister" method="post">
		<table
			style="width:300px; height:300px; position:fixed;
			 margin-left:-150px; margin-top:-150px; top:50%; left:50%;">
			 <caption style="color: #FFFFFF; align: center; font-size: 40px; text-shadow: 0 0 3px #FF0000, 0 0 5px #0000FF;">Login Page</caption>
			<tr>
			<td><h3 style="color: #4EB1BA;">${message} </h3>
				<h3 style="color: #E9E9E9;">${successMessage}</h3>
			</tr>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="login"></td>
				<td><a href="register.jsp" style="font-size: 30px; color: red;">Registration</a></td>
			</tr>
		</table>
	</form>
</body>
</html>