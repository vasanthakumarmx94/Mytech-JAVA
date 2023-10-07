<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.neosoft.crud.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	User user = UserController.getUsersById(Integer.parseInt(id));
	%>

	<h1>Edit Form</h1>

	<form action="edituser.jsp" method="post">

		<input type="hidden" name="id" value="<%=user.getId()%>" />

		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"
					value="<%=user.getName()%>" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="<%=user.getPassword()%>" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"
					value="<%=user.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male" />Male <input
					type="radio" name="gender" value="female" />Female</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country" style="width: 155px">
						<option>India</option>
						<option>England</option>
						<option>Australia</option>
						<option>USA</option>
						<option>Other</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit User" /></td>
			</tr>
		</table>
	</form>


</body>
</html>