package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carrent.beans.CustomerBean;
import com.carrent.dao.CustomerDao;

@WebServlet(urlPatterns = "/addcustomer")
public class AddCustomerServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Carbooking</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");

		CustomerBean cbean = new CustomerBean();
		cbean.setCusname(req.getParameter("cusname"));
		cbean.setCusmobile(req.getParameter("cusmobile"));
		cbean.setCusemail(req.getParameter("cusemail"));
		cbean.setCuscity(req.getParameter("cuscity"));
		cbean.setCusstate(req.getParameter("cusstate"));
		cbean.setCuspin(req.getParameter("pin"));
		cbean.setCusaddress(req.getParameter("address"));
		int i = CustomerDao.Customersave(cbean);
		if (i > 0) {
			out.print("<h4>Customer added successfully</h4>");
		}else {
			out.print("<h4>Customer details not Saved!!</h4>");
		}
		req.getRequestDispatcher("addcustomerform.html").include(req, resp);
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
		
	
	}

}
