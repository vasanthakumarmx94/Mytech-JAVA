<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="com.neosoft.crud.*" %>

<jsp:useBean id="user" class="com.neosoft.crud.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<%
	int status = UserController.UpdateUser(user);
	response.sendRedirect("viewuser.jsp");
%>