<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<meta charset="UTF-8">
<body>
</head>

<!-- 2 -->
<body style="background-color: pink;">
	<div align="center">

		<h2>Login Form</h2>
		<form action="/login" method="post">
			<fieldset style="background-color: white;">
				<table>
					<p>
					<tr>
						<td>Email:</td>

						<td><input type="text" name="email" /></td>
					</tr>
					<br>
					<tr>
						<td>Password:</td>
						<td><input type="text" name="password" /></td>
					</tr>
				</table>
				<button>Submit</button>


			</fieldset>
		</form>
	</div>
</body>
</html>