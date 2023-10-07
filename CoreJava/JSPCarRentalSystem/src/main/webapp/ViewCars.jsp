<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.neosoft.beans.*, com.neosoft.dao.*, java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Rental system</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
<style type="text/css">
table {
	border: 5px solid maroon;
}

th, td {
	padding: 0px 5px 0px 5px;
}

th {
	height: 40px;
	color: yellow;
	background-color: teal;
}
</style>
</head>
<body>
	<%
	HttpSession nsession = request.getSession(false);
	if (nsession != null) {
	%>

	<jsp:include page="navadmin.html"></jsp:include>

	<%
	List<CarBean> cars = CarDao.getAllCars();
	request.setAttribute("cars", cars);
	%>

	<div class="usertable">
		<h1>Cars List</h1>
		<table border="3" width="100%" aligne="center">
			<tr>
				<th>CarId</th>
				<th>Car Name</th>
				<th>Car Type</th>
				<th>Car Company</th>
				<th>Car City</th>
				<th>Car Number</th>
				<th>Car Description</th>
				<th>Price Per Day</th>
				<th>Availability status</th>
				<th>Edit</th>
				<th>delete</th>
			</tr>
			<c:forEach items="${cars}" var="car">
				<tr>
					<td>${car.getId()}</td>
					<td>${car.getCarname()}</td>
					<td>${car.getCartype()}</td>
					<td>${car.getCarcompany()}</td>
					<td>${car.getCarcity()}</td>
					<td>${car.getCarnumaber()}</td>
					<td>${car.getCardescription()}</td>
					<td>${car.getPriceperday()}</td>
					<td>${car.getIssustatus()}</td>
					<td><a href="EditCarForm.jsp?id=${car.getId()}"><button
								class='btn btn-primary'>Edit</button></a></td>
					<td><a href="deletecar.jsp?id=${car.getId()}"><button
								class='btn btn-danger'>Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:include page="dashboardfooter.jsp" />
	<%
	} else {
	response.sendRedirect("index.html");
	}
	%>


</body>
</html>