package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carrent.beans.EmployeeBean;
import com.carrent.dao.EmployeeDao;


@WebServlet(urlPatterns = "/addemployee")
public class AddEmployeeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Employee</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");

		EmployeeBean cbean = new EmployeeBean();
		cbean.setFirstname(req.getParameter("fname"));
		cbean.setMiddlename(req.getParameter("mname"));
		cbean.setLastname(req.getParameter("lname"));
		cbean.setGender(req.getParameter("gender"));
		cbean.setDate(req.getParameter("date"));
		cbean.setNationality(req.getParameter("nationality"));
		cbean.setEmail(req.getParameter("email"));
		cbean.setMobile(req.getParameter("mobile"));
		cbean.setAddress(req.getParameter("address"));
		cbean.setCity(req.getParameter("city"));
		cbean.setState(req.getParameter("state"));
		cbean.setPincode(req.getParameter("pincode"));
		cbean.setUname(req.getParameter("uname"));
		cbean.setPassword(req.getParameter("password"));
		
		
		
		if( req.getParameter("password").equals(req.getParameter("cpassword"))) {
			
			int i = EmployeeDao.Employeesave(cbean);
			if (i > 0) {
				out.print("<h4>Employee added successfully</h4>");
			}else {
				out.print("<h4>Employee details not Saved!!</h4>");
			}
			req.getRequestDispatcher("addemployeeform.html").include(req, resp);
			out.println("</div>");
			req.getRequestDispatcher("footer.html").include(req, resp);
			out.close();
			
		}else {
		
		out.print("<h4>Please verify password and confirm password should be same</h4>");
		req.getRequestDispatcher("addemployeeform.html").include(req, resp);
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
		}
		
		
	}
	
	
}
