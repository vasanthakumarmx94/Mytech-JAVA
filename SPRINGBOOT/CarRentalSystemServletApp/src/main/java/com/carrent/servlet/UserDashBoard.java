package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/userdashboard")
public class UserDashBoard extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session = req.getSession();
		
		String email=(String)session.getAttribute("email");
		if(email!=null) {
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>User DashBoard</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navuser.html").include(req, resp);
		out.println("<div class='container'>");
		req.getRequestDispatcher("admincarousel.html").include(req, resp);
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
		}
	}
	
}
