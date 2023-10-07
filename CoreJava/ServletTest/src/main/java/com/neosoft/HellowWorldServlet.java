package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HellowWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Hello World!!");
		

		ServletContext sct = getServletContext();
		Enumeration<String> en3 = sct.getInitParameterNames();
		out.print("<br><table border=1>");
		while (en3.hasMoreElements()) {
			String param = en3.nextElement();
			out.print("<tr> <td>" + param + "</td><td>" + sct.getInitParameter(param) + "</td></tr>");
		}
		out.print("</table>");
		out.close();
	}

}
