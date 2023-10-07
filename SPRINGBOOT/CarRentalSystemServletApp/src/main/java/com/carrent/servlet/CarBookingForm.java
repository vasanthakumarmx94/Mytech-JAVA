package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/carbookingform")

public class CarBookingForm extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Librarian Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navuser.html").include(req, resp);
		out.println("<div class='container'>");
		int carid=Integer.parseInt(req.getParameter("carid"));
		//out.println(carid);
		
		out.print("<h3>Enter Your Details For Booking </h3>");
		out.print(" <form action='carbooking' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<label for='carid1'>Car Id</label>");
		out.print("<input type='number' class='form-control' name='carid' id='carid1' value='"+ carid+"' readonly/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='name1'>Full Name</label>");
		out.print("<input type='text' class='form-control' name='fullname' id='fullname1' placeholder='Full Name'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='mobile'>Mobile</label>");
		out.print("<input type='text' class='form-control' name='mobile' id='cusmobile1' placeholder='Contact Number'/>");
		out.print(" </div>");
		out.print(" <div class='form-group'>");
		out.print("  <label for='email'>Email</label>");
		out.print("  <input type='email' class='form-control' name='email' id='email1' placeholder='Email'/>");
		out.print("  </div>");	  
		out.print(" <div class='form-group'>");
		out.print(" <label for='fdate'>From Date</label>");
		out.print("  <input type='date' class='form-control' name='fdate' id='fdate1'/>");
		out.print("  </div>");
		out.print(" <div class='form-group'>");
		out.print(" <label for='tdate'>To Date</label>");
		out.print("  <input type='date' class='form-control' name='tdate' id='tdate1'/>");
		out.print("  </div>");
		out.print(" <div class='form-group'>");
		out.print(" <label for='paddress'>PickUp Address</label>");
		out.print("  <input type='text' height='50px' class='form-control' name='paddress' id='cuscity1' placeholder='Pick Up Address'/>");
		out.print("  </div>");
		out.print(" <div class='form-group'>");
		out.print(" <label for='daddress'>Drop Address</label>");
		out.print(" <input type='text' height='50px' class='form-control' name='daddress' id='daddress1' placeholder='Drop Address'/>");
		out.print(" </div>");
		
		out.print("  <button type='submit' class='btn btn-primary'>Book MyCar</button> "); 
		out.print("  <input type='reset' value='ResetForm'  style='background-color: #538cc6'> "); 
		out.print("	</form> "); 

		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
		
	}
	
	
	
}
