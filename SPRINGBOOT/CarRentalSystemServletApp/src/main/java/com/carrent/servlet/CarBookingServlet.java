package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carrent.beans.CarBookingBean;
import com.carrent.dao.CarDao;

@WebServlet(urlPatterns = "/carbooking")
public class CarBookingServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>CarBooking</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		req.getRequestDispatcher("navuser.html").include(req, resp);
		out.println("<div class='container'>");
		
		HttpSession session=req.getSession(false);  
        String email=(String)session.getAttribute("email"); 
		//out.println(email);
		CarBookingBean cbean = new CarBookingBean();
		cbean.setCarid(Integer.parseInt(req.getParameter("carid")));
		cbean.setFullname(req.getParameter("fullname"));
		cbean.setMobile(req.getParameter("mobile"));
		cbean.setEmail(req.getParameter("email"));
		cbean.setFdate(req.getParameter("fdate"));
		cbean.setTdate(req.getParameter("tdate"));
		cbean.setPaddress(req.getParameter("paddress"));
		cbean.setDaddress(req.getParameter("daddress"));
		int i = CarDao.Bookmycar(cbean,email);
		int carid=Integer.parseInt(req.getParameter("carid"));
		int j=CarDao.updatecarbooking(carid);
		if (i > 0 && j>0) {
			out.print("<h4>Car Booking successfull</h4>");
		}else {
			out.print("<h4>Car Not Booked Try again!!</h4>");
		}
		
		req.getRequestDispatcher("availablecars").include(req, resp);
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
		
	
	}

}
