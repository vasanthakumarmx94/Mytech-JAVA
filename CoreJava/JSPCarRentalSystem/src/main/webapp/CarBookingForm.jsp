<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
int carid = Integer.parseInt(request.getParameter("id"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Car</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
</head>
<body>
	<jsp:include page="navuser.html"></jsp:include>

<section class="bookingformbody">
	<h3>Enter Your Details For Booking</h3>
	<form action='carbooking.jsp' method='post' style='width: 300px'>
		<div class='form-group'>
			<label for='carid1'>Car Id</label> <input type='number'
				class='form-control' name='carid' id='carid1' value='<%= carid %>'
				readonly />
		</div>
		<div class='form-group'>
			<label for='name1'>Full Name</label> <input type='text'
				class='form-control' name='fullname' id='fullname1'
				placeholder='Full Name' />
		</div>
		<div class='form-group'>
			<label for='mobile'>Mobile</label> <input type='text'
				class='form-control' name='mobile' id='cusmobile1'
				placeholder='Contact Number' />
		</div>
		<div class='form-group'>
			<label for='email'>Email</label> <input type='email'
				class='form-control' name='email' id='email1' placeholder='Email' />
		</div>
		<div class='form-group'>
			<label for='fdate'>From Date</label> <input type='date'
				class='form-control' name='fdate' id='fdate1' />
		</div>
		<div class='form-group'>
			<label for='tdate'>To Date</label> <input type='date'
				class='form-control' name='tdate' id='tdate1' />
		</div>
		<div class='form-group'>
			<label for='paddress'>PickUp Address</label> <input type='text'
				height='50px' class='form-control' name='paddress' id='cuscity1'
				placeholder='Pick Up Address' />
		</div>
		<div class='form-group'>
			<label for='daddress'>Drop Address</label> <input type='text'
				height='50px' class='form-control' name='daddress' id='daddress1'
				placeholder='Drop Address' />
		</div>

		<button type='submit' class='btn btn-primary'>Book MyCar</button>
		<button type="reset" class='btn btn-primary'>ResetForm</button>
	</form>
</section>

	<jsp:include page="dashboardfooter.jsp" />


</body>
</html>