<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- html comment -->
	<%-- <jsp:forward page="tagTest.jsp">
<jsp:param value="101" name="param1"/>
<jsp:param value="102" name="param2"/>
<jsp:param value="103" name="param3"/> 
</jsp:forward>--%>

	<%--jsp  include the contents --%>
	<%-- <jsp:include page="tagTest.jsp"></jsp:include> --%>





	<%--jsp comment --%>

	<%--this is get parameters which is jsp:forword,jsp:param --%>
	<%-- <b>Id1:</b> <%= request.getParameter("param1") %><br>
<b>Id2:</b> <%= request.getParameter("param2") %> --%>


	<jsp:useBean id="user" class="com.neosoft.User" />
	<jsp:setProperty name="user" property="uname" value="admin" />
	<jsp:setProperty name="user" property="upass" value="admin123" />

	<%
	String uname = request.getParameter("uname");
	String upass = request.getParameter("upass");
	if (uname.equals(user.getUname()) && upass.equals(user.getUpass())) {
	%>
	<h3>Welcome to my site..</h3>
	<jsp:getProperty property="uname" name="user" />
	<jsp:include page="registeration.jsp" />
	<%
	} else {
	%>
	<jsp:forward page="login.html"></jsp:forward>
	<%
	}
	%>



</body>
</html>