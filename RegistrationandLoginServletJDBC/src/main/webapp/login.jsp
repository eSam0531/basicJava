<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>

<body>
	<div align="center">
		<h1>User Login</h1>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table style="with: 100%">
				<tr>
				<!-- input for username -->
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
				<!-- input for password -->
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<!-- submit button -->
			<input type="submit" value="Submit" />
			<br>
			<!-- adds link to register new user page -->
			<a href="userregister.jsp">Register New User</a>
		</form>
	</div>
</body>
</html>