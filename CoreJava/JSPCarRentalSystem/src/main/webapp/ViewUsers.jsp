<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.neosoft.beans.*, com.neosoft.dao.*, java.util.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Rental System</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
<style type="text/css">
table{
border: 5px solid maroon;
}
th,td{
padding: 0px 5px 0px 5px;

}
th{
height:40px;
color: yellow;
background-color: teal;
}
</style>
</head>
<body>
<jsp:include page="navadmin.html"></jsp:include>

	<%
	List<UserBean> users = UserDao.getAllUsers();
	request.setAttribute("users", users);
	
	%>
	
<div class="usertable">
<h1>Users List</h1>
	<table border="3" width="90%">
		<tr>
			<th>UserId</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>State</th>
			<th>City</th>
			<th>Pin Code</th>
			<th>Address</th>
			<th>Email</th>
			<th>password</th>
			<th>Edit</th>
			<th>delete</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.getUserid()}</td>
				<td>${user.getName()}</td>
				<td>${user.getMobile()}</td>
				<td>${user.getState()}</td>
				<td>${user.getCity()}</td>
				<td>${user.getPincode()}</td>
				<td>${user.getAddress()}</td>
				<td>${user.getEmail()}</td>
				<td>${user.getPassword()}</td>
				<td><a href="editform.jsp?userid=${user.getUserid()}"><button class='btn btn-primary'>Edit</button></a></td>
				<td><a href="deleteuser.jsp?userid=${user.getUserid()}"><button class='btn btn-danger'>Delete</button></a></td>
			</tr>
		</c:forEach>
	</table>
	</div>

	<jsp:include page="dashboardfooter.jsp" />
</body>
</html>