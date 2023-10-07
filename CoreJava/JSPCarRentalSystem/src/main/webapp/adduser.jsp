<%@page import="com.neosoft.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <jsp:useBean id="userbean" class="com.neosoft.beans.UserBean" />
<jsp:setProperty property="*" name="userbean" />
    
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
if(nsession.getAttribute("email")!=null) {
  
	int status = UserDao.Usersave(userbean);
	if (status > 0) {
	%>
	<jsp:include page="navadmin.html"></jsp:include>
	<h3 style="color: green">Record saved successfully!!</h3>
	<jsp:include page="adduserform.html"></jsp:include>
	<jsp:include page="dashboardfooter.jsp"></jsp:include>

	<%
	} else {
	%>

	<jsp:include page="navadmin.html"></jsp:include>
	<h3 style="color: red">Record not saved!!</h3>
	<jsp:include page="adduserform.html"></jsp:include>
	<jsp:include page="dashboardfooter.jsp"></jsp:include>

	<%
	}
}
else{
	response.sendRedirect("index.html");
}
  
	%>


</body>
</html>