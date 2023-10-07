package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carrent.beans.EmployeeBean;
import com.carrent.dao.EmployeeDao;

@WebServlet(urlPatterns = "/viewemployee")
public class ViewEmployee extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Employees</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");

		List<EmployeeBean> list = EmployeeDao.viewall();

		out.println("<table class='table table-bordered table-striped'>");
		out.println(
				"<tr><th>EmpId</th><th>Employee Name</th><th>Gender</th><th>DOB</th> "
						+ "<th>Nationality</th><th>Email</th><th>Mobile</th><th>Address</th><th>City</th><th>State</th> <th>PINCODE</th>"
						+ "<th>UserName</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
		for (EmployeeBean bean : list) {
			out.println("<tr><td>" + bean.getEmpid() + "</td><td>" + bean.getFirstname() + " " + bean.getMiddlename()
					+ " " + bean.getLastname() + "</td><td>" + bean.getGender() + "</td><td>" + bean.getDate()
					+ "</td><td>" + bean.getNationality() + "</td><td>" + bean.getEmail() + "</td><td>"
					+ bean.getMobile() + "</td><td>" + bean.getAddress() + "</td><td>" + bean.getCity() + "</td><td>"
					+ bean.getState() + "</td><td>" + bean.getPincode() + "</td><td>" + bean.getUname() + "</td><td>"
					+ bean.getPassword() + "</td><td><a href='EditEmployeeForm?id=" + bean.getEmpid()
					+ "'><button class='btn btn-primary'> Edit</button></a></td><td><a href='DeleteEmployee?id=" + bean.getEmpid() + "'><button class='btn btn-danger'> Delete</button></a></td></tr>");
		}
		out.println("</table>");

		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}
