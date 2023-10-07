<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CarRentalSystem</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
</head>
<body>

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
					<li><a href="index.html" class="active">Home</a></li>
<!-- 					<li><a href="#">AboutUs</a></li> -->
					<!-- 					<li><a href="#">BookCar</a></li> -->
					<li><a href="UserRegisterForm.jsp">Register</a></li>
					<li><a href="index.html">Login</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

<jsp:include page="userregisterform.html"></jsp:include>

<jsp:include page="dashboardfooter.jsp"></jsp:include>

</body>
</html>