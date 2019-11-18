
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register</title>
</head>
<body style="background-color: pink;">
	<form action="<%=request.getContextPath()%>/register" method="post">
		<table
			style="width: 300px; height: 300px; position: fixed; margin-left: -150px; margin-top: -150px; top: 50%; left: 50%;">
			<caption
				style="color: #FFFFFF; align: center; font-size: 40px; text-shadow: 0 0 3px #FF0000, 0 0 5px #0000FF;">Registration
				Page</caption>
			<tr>
				<td><h3 style="color: #4EB1BA;">${successMessage}</h3></td>
				<td><h3 style="color: #4EG9BA;">${message}</h3></td>
			</tr>
			<tr>
				<td>First name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Username: </td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="register"></td>
				<td><a href="login.jsp" style="font-size: 30px; color: red;">Login</a></td>
			</tr>
		</table>
	</form>
</body>
</html>