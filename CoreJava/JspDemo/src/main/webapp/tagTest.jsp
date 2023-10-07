<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="WEB-INF/custom.tld" prefix="mytag" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Tag</title>
</head>
<body>
<%-- <mytag:CurrentDateTime/><br> --%>
<%-- <mytag:CurrentTime>Current Time Is:</mytag:CurrentTime> --%>
<!-- <br> -->
<%-- <mytag:RepeatText frequency="10">java</mytag:RepeatText> --%>
<!-- <br> -->

<mytag:greeting>Vasanthakumar</mytag:greeting>
<br>

<%-- <mytag:searchtext Case="0" text="java"> Java is easy to learn .we need to practice java</mytag:searchtext> --%>

<%-- <mytag:searchtext Case="1" text="java"> Java is easy to learn .we need to practice java</mytag:searchtext> --%>

</body>
</html>