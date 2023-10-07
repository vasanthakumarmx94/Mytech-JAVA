<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.neosoft.dao.*"%>


<jsp:useBean id="carbean" class="com.neosoft.beans.CarBean" />
<jsp:setProperty property="*" name="carbean" />



<%
out.print(carbean.getIssustatus());
//request.setAttribute("carbean", carbean);
int status = CarDao.UpdateCar(carbean);
if (status > 0) {
	response.sendRedirect("ViewCars.jsp");
}
%>