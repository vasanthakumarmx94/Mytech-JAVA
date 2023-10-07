package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dateServlet")
public class DateServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	String msg=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		msg="welcome..";
		System.out.println("I am initialize...");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Service method called...");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h3>Today Date is:<h3>");
		out.println("<h2>"+new java.util.Date().toString()+"</h2>");
		out.close();
		
	}
	
	@Override
	public void destroy() {
		msg=null;
	}
	
}
