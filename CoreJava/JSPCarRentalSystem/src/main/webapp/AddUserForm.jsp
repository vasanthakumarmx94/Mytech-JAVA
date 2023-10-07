<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<jsp:include page="adduserform.html"></jsp:include>

	<jsp:include page="dashboardfooter.jsp"></jsp:include>

<%
}
else{
	response.sendRedirect("index.html");
}
%>

</body>
</html>