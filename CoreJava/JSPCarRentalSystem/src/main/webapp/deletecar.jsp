<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.neosoft.dao.*"%>

<jsp:useBean id="car" class="com.neosoft.beans.CarBean"></jsp:useBean>
<jsp:setProperty property="*" name="car" />

<%
int status = CarDao.deleteCar(car);
response.sendRedirect("ViewCars.jsp");
%>
