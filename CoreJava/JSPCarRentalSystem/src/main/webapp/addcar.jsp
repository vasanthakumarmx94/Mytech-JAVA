
<%@page import="com.neosoft.dao.CarDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:useBean id="carbean" class="com.neosoft.beans.CarBean" />
<jsp:setProperty property="*" name="carbean" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CAR Rental System</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="main.css" />
<style type="text/css">
</style>
</head>
<body>
	<%
	int status = CarDao.Carsave(carbean);
	if (status > 0) {
	%>
	<jsp:include page="navadmin.html"></jsp:include>
	<h3>Record saved successfully!!</h3>
	<jsp:include page="addcarform.html"></jsp:include>
	<jsp:include page="dashboardfooter.jsp"></jsp:include>

	<%
	} else {
	%>

	<jsp:include page="navadmin.html"></jsp:include>
	<h3>Record not saved!!</h3>
	<jsp:include page="addcarform.html"></jsp:include>
	<jsp:include page="dashboardfooter.jsp"></jsp:include>

	<%
	}
	%>
</body>
</html>
