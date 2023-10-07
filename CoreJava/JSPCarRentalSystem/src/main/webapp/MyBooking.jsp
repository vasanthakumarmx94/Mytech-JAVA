<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.neosoft.dao.*, com.neosoft.beans.*,java.util.* " %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String email = (String) session.getAttribute("email");
String password = (String) session.getAttribute("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Available Cars</title>
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
	<jsp:include page="navuser.html"></jsp:include>

	<%
	UserBean user = UserDao.getUserByMail(email);

	int userid = user.getUserid();

	List<CarBookingBean> carbooks = CarDao.viewMyBooking(userid);
	request.setAttribute("carbooks", carbooks);
	int counter = 0;
	%>



	<div class="usertable">
		<h1>My Booking</h1>
		<table border="3" width="100%" aligne="center">
			<tr>
				<th>Sl. No</th>
				<th>Name</th>
				<th>mobile</th>
				<th>Email</th>
				<th>Car Id</th>
				<th>From Date</th>
				<th>To Date</th>
				<th>User Id</th>
				<th>Amount</th>
				<th>Return Status</th>
				<th colspan="2">Action</th>

			</tr>
			<c:forEach items="${carbooks}" var="carbook">
				<tr>
					<td><%=++counter%></td>
					<td>${carbook.getFullname()}</td>
					<td>${carbook.getMobile()}</td>
					<td>${carbook.getEmail()}</td>
					<td>${carbook.getCarid()}</td>
					<td>${carbook.getFdate()}</td>
					<td>${carbook.getTdate()}</td>
					<td>${carbook.getUserid()}</td>
					<td>${carbook.getAmount()}</td>
					<c:choose>
						<c:when test="${carbook.getReturnstatus().equals('No')}">
							<td><button class='btn btn-danger'>${carbook.getReturnstatus()}</button></td>
							<td><a href="ReturnCar.jsp?bid=${carbook.getBookingid()}">
									<button class='btn btn-primary'>Return Now</button></a></td>
						</c:when>
						<c:otherwise>
						<td><button class='btn btn-success'>${carbook.getReturnstatus()}</button></td>
							<td><button class='btn btn-success'>Returned</button></td>
						</c:otherwise>
					</c:choose>

				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="dashboardfooter.jsp" />

</body>
</html>