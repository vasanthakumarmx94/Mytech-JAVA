<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
   

	 HttpSession session1=request.getSession(false);  
   if(session!=null){  
   String email = (String) session1.getAttribute("email");
	String password = (String) session1.getAttribute("password");
		if (email.equals("admin@gmail.com") && password.equals("admin123")) {
	
    
   