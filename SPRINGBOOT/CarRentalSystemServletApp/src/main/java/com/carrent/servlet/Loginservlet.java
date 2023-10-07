package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/adminlogin")
public class Loginservlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		if(email.equals("admin@gmail.com")&&password.equals("admin123")){
			
			HttpSession session=req.getSession();
			session.setAttribute("admin","true");
			
			req.getRequestDispatcher("admindashboard.html").forward(req, resp);
//			req.getRequestDispatcher("navadmin.html").include(req, resp);
//			req.getRequestDispatcher("admincarousel.html").include(req, resp);
			
		}else{
			req.getRequestDispatcher("navhome.html").include(req, resp);
			out.println("<div class='container'>");
			out.println("<h3>Username or password error</h3>");
			req.getRequestDispatcher("loginform.html").include(req, resp);
			out.println("</div>");
		}
		
		
		
		
	}

}
