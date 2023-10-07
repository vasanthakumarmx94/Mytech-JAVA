<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		
	%>

	<jsp:include page="navuser.html" />

	<jsp:include page="usercarousel.html" />

	<jsp:include page="dashboardfooter.jsp" />
	
	
	
	<script src="jquery.min.js"></script>
	<script src="bootstrap.min.js"></script>

</body>
</html>