<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


	<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	if (email.equals("admin@gmail.com") && password.equals("admin123")) {
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		response.sendRedirect("admindashboard.jsp");

	} else {
		//out.print(email);
		response.sendRedirect("index.html");
	}
	%>


