<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Registration Page</title>
</head>
<body style="background-color: pink; ">
	<form action="LoginRegister" method="post">
		<table style="width:300px; height:300px; position:fixed;
			 margin-left:-150px; margin-top:-150px; top:50%; left:50%;">
			
			<caption style="color: #FFFFFF; align: center; font-size: 40px; text-shadow: 0 0 3px #FF0000, 0 0 5px #0000FF;">Registration Page</caption>
			
			<tr><td><h3 style="color: #4EB1BA;">${message} </h3></td></tr>
			
			<tr>
				<td>UserName: </td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td>Retype password: </td>
				<td><input type="password" name="password2"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="register"></td>
			</tr>
		</table>
	</form>
</body>
</html>