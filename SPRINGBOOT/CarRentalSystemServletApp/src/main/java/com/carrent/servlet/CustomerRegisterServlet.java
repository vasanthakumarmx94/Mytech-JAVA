package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carrent.beans.UserBean;
import com.carrent.dao.CustomerDao;

@WebServlet(urlPatterns = "/customerregister")
public class CustomerRegisterServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Librarian</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		req.getRequestDispatcher("navhome.html").include(req, resp);
		out.println("<div class='container'>");

		UserBean cbean = new UserBean();
		cbean.setName(req.getParameter("fname"));
		cbean.setMobile(req.getParameter("mobile"));
		cbean.setEmail(req.getParameter("cemail"));
		cbean.setPassword(req.getParameter("password"));

		cbean.setState(req.getParameter("state"));
		cbean.setCity(req.getParameter("city"));
		cbean.setPincode(req.getParameter("pin"));
		cbean.setAddress(req.getParameter("address"));

		if (req.getParameter("password").equals(req.getParameter("cpassword"))) {

			int i = CustomerDao.CustomerRegister(cbean);
			if (i > 0) {
				out.print("<h4>User Registerd successfully</h4>");
			} else {
				out.print("<h4>User details not Saved!!</h4>");
			}
			req.getRequestDispatcher("loginuserform.html").include(req, resp);
			out.println("</div>");
			req.getRequestDispatcher("footer.html").include(req, resp);
			out.close();
		} else {

			out.print("<h4>Please verify password and confirm password should be same</h4>");
			req.getRequestDispatcher("customerregisterform.html").include(req, resp);
			out.println("</div>");
			req.getRequestDispatcher("footer.html").include(req, resp);
			out.close();
		}

	}

}
