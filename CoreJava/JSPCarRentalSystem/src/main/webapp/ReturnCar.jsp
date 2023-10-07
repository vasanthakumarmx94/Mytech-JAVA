<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.neosoft.dao.*"%>

   
<%
int bookingid=Integer.parseInt(request.getParameter("bid"));

int status = CarDao.ReturnMyCar(bookingid);
if(status>0){
response.sendRedirect("MyBooking.jsp");
}
%>