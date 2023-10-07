<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.neosoft.dao.*, com.neosoft.beans.*, java.util.*,java.time.LocalDate,java.time.temporal.ChronoUnit"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="bookcar" class="com.neosoft.beans.CarBookingBean" />
<jsp:setProperty property="*" name="bookcar" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CAR Rental System</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
<style type="text/css">
table, th, td {
 
  border-collapse: collapse;
}
th, td {
  padding: 5px;
}
</style>
</head>
<body>

	<%
	String email = (String) session.getAttribute("email");
	
	 
	int status = CarDao.Bookmycar(bookcar, email,bookcar.getCarid());
	if (status > 0) {
		UserBean users = UserDao.getUserByMail(email);
		request.setAttribute("users", users);
		
		String fdate=bookcar.getFdate();
		String tdate=bookcar.getTdate();
		
		LocalDate fdate1 = LocalDate.parse(fdate);
		LocalDate tdate1 = LocalDate.parse(tdate);
		 long days = ChronoUnit.DAYS.between(fdate1, tdate1);
		 
		CarBean cars= CarDao.getCarById(bookcar.getCarid());
		request.setAttribute("cars", cars);
		
	%>
	<jsp:include page="navuser.html"></jsp:include>
	<div class="bookack">
	<h3>You are Car Booking Successfully</h3>
	<h1>Acknowledgement</h1><br>
	<table>
			<tr><th>Name:</th><td><%= users.getName() %></td><th>Contact Number:</th><td><%= users.getMobile() %></td></tr>
			<tr><th>CarId:</th><td><%=bookcar.getCarid() %></td><th>Car Number:</th><td><%= cars.getCarnumaber() %></td></tr>
			<tr><th>From Date:</th><td><%= bookcar.getFdate() %></td><th>TO Date:</th><td><%= bookcar.getTdate() %></td></tr>
			<tr><th>Pick Up Address:</th><td><%= bookcar.getPaddress() %></td><th>Drop address:</th><td><%= bookcar.getDaddress() %></td></tr>
			<tr><th>Booking Status:</th><td>Success</td></tr>
			<tr><th>BILL:</th><td><%= days %>*<%=cars.getPriceperday() %></td><th>TOTAL AMOUNT:</th><td><%= cars.getPriceperday()*days %> Rs</td></tr>
	</table>
</div>

	<jsp:include page="dashboardfooter.jsp" />
	<%
	}
	%>







</body>
</html>