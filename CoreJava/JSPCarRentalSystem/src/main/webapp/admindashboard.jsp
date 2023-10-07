<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Rental System</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>

</head>
<body>
	<%
	 HttpSession session1=request.getSession(false);   
    String email = (String) session1.getAttribute("email");
	String password = (String) session1.getAttribute("password");
		if (email.equals("admin@gmail.com") && password.equals("admin123")) {
	%>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Car Rental System</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="admindashboard.jsp">Home</a></li>
					<li><a href="AddCarForm.jsp">Add Car</a></li>
					<li><a href="AddUserForm.jsp">Add User</a></li>
					<li><a href="ViewCars.jsp">View Cars</a></li>
					<li><a href="ViewUsers.jsp">View Users</a></li>
					<li><a href="BookingReport.jsp">Booking Report</a></li>
					<li><a href="logout.jsp">Logout</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<jsp:include page="admincarousel.html" />

	<% }else{
		%>
	<jsp:forward page="index.html" />
	<%} %>

	<jsp:include page="dashboardfooter.jsp" />
	<script src="jquery.min.js"></script>
	<script src="bootstrap.min.js"></script>

</body>
</html>








