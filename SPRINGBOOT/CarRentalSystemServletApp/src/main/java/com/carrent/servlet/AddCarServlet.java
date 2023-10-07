package com.carrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carrent.beans.CarBean;
import com.carrent.dao.CarDao;

@WebServlet(urlPatterns = "/Addcar")
public class AddCarServlet extends HttpServlet {

	
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

		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");

//	String carname=req.getParameter("carname");
//	String cartype=req.getParameter("cartype");
//	String carcompany=req.getParameter("carcompany");
//	String carcity=req.getParameter("carcity");
//	String carnumaber=req.getParameter("carnumaber");
//	double priceperday=Double.parseDouble(req.getParameter("priceperday"));
//	String cardescription=req.getParameter("cardescription");

		// CarBean bean=new CarBean(carname, cartype, carcompany,
		// carcity,carnumaber,priceperday,cardescription);

		CarBean cbean = new CarBean();
		cbean.setCarname(req.getParameter("carname"));
		cbean.setCartype(req.getParameter("cartype"));
		cbean.setCarcompany(req.getParameter("carcompany"));
		cbean.setCarcity(req.getParameter("carcity"));
		cbean.setCarnumaber(req.getParameter("carnumaber"));
		cbean.setPriceperday(Double.parseDouble(req.getParameter("priceperday")));
		cbean.setCardescription(req.getParameter("cardescription"));
		int i=CarDao.Carsave(cbean);
		if (i>0) {
			out.print("<h4>Car added successfully</h4>");
		}else {
			out.print("<h4>Car Details not saved!!!</h4>");
		}
			
			req.getRequestDispatcher("addcarform.html").include(req, resp);
			out.println("</div>");
			req.getRequestDispatcher("footer.html").include(req, resp);
			out.close();
			
	}

}
