<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<div align="center">
		<h1>User Registration Form</h1>
		<form action="<%=request.getContextPath()%>/register" method="post">
			<table style="with: 80%">
				<tr>
				<!-- input for first name -->
					<td>First Name</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
				<!-- input for last name -->
					<td>Last Name</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
				<!-- input for user name -->
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
				<!-- input for password -->
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
				<!-- input for email -->
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
			</table>
			<!-- submit button -->
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>