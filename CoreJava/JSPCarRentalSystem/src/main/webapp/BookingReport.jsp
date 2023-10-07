<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.neosoft.dao.*, com.neosoft.beans.*,java.util.* " %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CAR Rental System</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
</head>
<body>
<%
HttpSession nsession = request.getSession(false);
if(nsession!=null) 
{ 
%>
<jsp:include page="navadmin.html"></jsp:include>

	<%
	List<CarBookingBean> carbooks = CarDao.ViewAllBooking();
	request.setAttribute("carbooks", carbooks);
	int counter = 0;
	%>

	<div class="usertable">
		<h1>Booking Report</h1>
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
<!-- 				<th colspan="2">Action</th> -->

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
<%-- 							<td><a href="ReturnCar.jsp?bid=${carbook.getBookingid()}"> --%>
<!-- 									<button class='btn btn-primary'>Return Now</button></a></td> -->
						</c:when>
						<c:otherwise>
						<td><button class='btn btn-success'>${carbook.getReturnstatus()}</button></td>
<!-- 							<td><button class='btn btn-success'>Returned</button></td> -->
						</c:otherwise>
					</c:choose>

				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="dashboardfooter.jsp" />
<%
}
else{
	response.sendRedirect("index.html");
	
}
%>

</body>
</html>