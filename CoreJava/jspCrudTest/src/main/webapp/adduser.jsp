<%@page import="com.neosoft.crud.UserController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="user" class="com.neosoft.crud.User" />
<jsp:setProperty property="*" name="user" />


<%
int status = UserController.saveUser(user);
if (status > 0) {
	out.print("<h3>Record saved successfully!!</h3>");
%><jsp:include page="userform.html"></jsp:include>>

<%
} else {
out.print("<h3>Record not saved!!</h3>");
%>
<jsp:include page="userform.html"></jsp:include>

<%
}
%>



