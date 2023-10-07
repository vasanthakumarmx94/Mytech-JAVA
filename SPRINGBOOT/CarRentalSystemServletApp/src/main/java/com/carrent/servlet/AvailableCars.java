package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carrent.beans.CarBean;
import com.carrent.dao.CarDao;

@WebServlet(urlPatterns = "/availablecars")
public class AvailableCars extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Availablecars</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		request.getRequestDispatcher("navuser.html").include(request, response);
		out.println("<div class='container'>");
		out.println("<h2>Cars Details Book Available Cars</h2>");
		
		List<CarBean> list = CarDao.viewavailablecar();

		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Car Name</th><th>CarType</th><th>CarCompony</th> "
						+ "<th>City</th><th>Car Number</th><th>Description</th><th>Price Per Day</th><th>Available Status</th><th>Action</th></tr>");
		for (CarBean bean : list) {
			out.println("<tr><td>" + bean.getCarname() + "</td><td> " + bean.getCartype()
					+ "</td><td> " + bean.getCarcompany() + "</td><td>" + bean.getCarcity() + "</td><td>" + bean.getCarnumaber()
					+ "</td><td>" + bean.getCardescription() + "</td><td>" + bean.getPriceperday() + "</td><td>"+bean.getIssustatus()+"</td>"
					+ "<td><a href='carbookingform?carid=" + bean.getId()
					+ "'><button class='btn btn-primary'> Click Here To Book</button></a></td></tr>");
		}
		out.println("</table>");

		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}
	
	
}
