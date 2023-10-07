package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="My servletConfig Test Servlet",
		description="This is my servlet to demonstrate the servlet config object",
		urlPatterns = "/Testconfig",
		initParams = {
				@WebInitParam(name="dbName",value="mydb"),
				@WebInitParam(name="dbType",value = "Oracle/Mysql")
		},
		loadOnStartup = 1
		
		)
public class ServletConfigTest extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		ServletConfig sc=getServletConfig();
		out.println("<h3>ServletName:"+sc.getServletName());
		// Get header information from the request		
		Enumeration<String> en2 = sc.getInitParameterNames();
		out.print("<br><table border=1>");
		while (en2.hasMoreElements()) {
			String param= en2.nextElement();
			out.print("<tr> <td>" + param + "</td><td>" + sc.getInitParameter(param) + "</td></tr>");
		}
		out.print("</table>");


		ServletContext sct=getServletContext();
		
		Enumeration<String> en3 = sct.getInitParameterNames();
		out.print("<br><table border=1>");
		while (en3.hasMoreElements()) {
			String param= en3.nextElement();
			out.print("<tr> <td>" + param + "</td><td>" + sct.getInitParameter(param) + "</td></tr>");
		}
		out.print("</table>");
	}
	
	
}
