package com.carrent.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carrent.beans.EmployeeBean;
import com.carrent.dao.EmployeeDao;

@WebServlet(urlPatterns = "/editemployee")
public class EditEmployeeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		cbean.setEmpid(Integer.parseInt(req.getParameter("empid")));
		
		if( req.getParameter("password").equals(req.getParameter("cpassword"))) {
			EmployeeDao.Employeeupdate(cbean);
			resp.sendRedirect("viewemployee");
			
		}
		
		
	}
	
	

}
