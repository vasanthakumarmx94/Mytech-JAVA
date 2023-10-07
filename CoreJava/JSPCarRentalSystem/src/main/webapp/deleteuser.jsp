<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="com.neosoft.dao.*" %>
    
<jsp:useBean id="user" class="com.neosoft.beans.UserBean"></jsp:useBean>
<jsp:setProperty property="*" name="user" />


<%

int status = UserDao.deleteUser(user);
response.sendRedirect("ViewUsers.jsp");
%>
    