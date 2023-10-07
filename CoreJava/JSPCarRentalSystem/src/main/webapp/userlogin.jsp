<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.neosoft.dao.UserDao"%>


<%
String email = request.getParameter("email");
String password = request.getParameter("password");
boolean status = UserDao.userauthenticate(email, password);

if (status == true) {
	session.setAttribute("email", email);
	session.setAttribute("password", password);
%>
<jsp:forward page="userdashboard.jsp" />
<%
} else {
%>
<jsp:forward page="index.html" />
<%
}
%>


