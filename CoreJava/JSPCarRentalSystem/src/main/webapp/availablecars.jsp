<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.neosoft.beans.*, com.neosoft.dao.*, java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Available Cars</title>
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
	<jsp:include page="navuser.html"></jsp:include>

	<%
	List<CarBean> cars = CarDao.viewavailablecar();
	request.setAttribute("cars", cars);
	int counter = 0;
	%>

	<div class="usertable">
		<h1>Available Cars</h1>
		<table border="3" width="100%" aligne="center">
			<tr>
				<th>Sl. No</th>
				<th>Car Number</th>
				<th>CarId</th>
				<th>Car Name</th>
				<th>Car Type</th>
				<th>Car Company</th>
				<th>Car City</th>
				<th>Car Description</th>
				<th>Price Per Day</th>
				<th>Status</th>
				<th>Action</th>

			</tr>
			<c:forEach items="${cars}" var="car">
				<tr>
					<td><%=++counter%></td>
					<td>${car.getCarnumaber()}</td>
					<td>${car.getId()}</td>
					<td>${car.getCarname()}</td>
					<td>${car.getCartype()}</td>
					<td>${car.getCarcompany()}</td>
					<td>${car.getCarcity()}</td>
					<td>${car.getCardescription()}</td>
					<td>${car.getPriceperday()}</td>
					<td><button class='btn btn-success'>${car.getIssustatus()}</button></td>
					<td><a href="CarBookingForm.jsp?id=${car.getId()}"><button
								class='btn btn-primary'>Book Now</button></a></td>

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