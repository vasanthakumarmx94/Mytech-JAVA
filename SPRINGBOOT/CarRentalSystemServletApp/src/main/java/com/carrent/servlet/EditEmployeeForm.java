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

@WebServlet(urlPatterns = "/EditEmployeeForm")
public class EditEmployeeForm extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit Employee Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		String empid = request.getParameter("id");
		int id = Integer.parseInt(empid);

		EmployeeBean bean = EmployeeDao.viewById(id);

		out.println("<form action='editemployee' method='post' style='width:600px'>");
		out.println("<div class='form-group'>");
		out.println("<input type='hidden' class='form-control' name='empid' id='date' value='"+ bean.getEmpid()+"'>");
		out.println(" </div>");
		out.print("<div class='form-row'>");
		out.print(" <div class='form-group col-md-4'>");
		out.print(" <label for='fname'>First Name</label>");
		out.print(" <input type='text' class='form-control' name='fname'value='" + bean.getFirstname()
				+ " ' placeholder='First Name'>");
		out.print("</div>");
		out.println(" <div class='form-group col-md-4'>");
		out.println(" <label for='mname'>Middle Name</label>");
		out.println(" <input type='text' class='form-control' name='mname' value='" + bean.getMiddlename()
				+ "'id='mname' placeholder='Middle Name'>");
		out.println(" </div>");
		out.println("<div class='form-group col-md-4'>");
		out.println("<label for='lname'>Last Name</label>");
		out.println("<input type='text' class='form-control' name='lname' value='" + bean.getLastname()
				+ "'id='lname' placeholder='Last Name'>");
		out.println(" </div>");
		out.println(" </div>");
		out.println("<div class='form-row'>");
		out.println(" <div class='form-group col-md-4'>");
		out.println("<label for='inputgender'>Gender</label>");
		out.println("<select id='gender1' class='form-control' name='gender' value='"+ bean.getGender()+"' >");
		out.println(" <option value='Male'>Male</option>");
		out.println(" <option value='Female'>Female</option>");
		out.println("</select>");
		out.println("</div>");
		out.println("<div class='form-group col-md-4'>");
		out.println(" <label for='mname'>Date Of Birth</label>");
		out.println("<input type='date' class='form-control' name='date' id='date' value='"+ bean.getDate()+"'>");
		out.println(" </div>");
		out.println("<div class='form-group col-md-4'>");
		out.println(" <label for='lname'>Nationality</label>");
		out.println("<input type='text' class='form-control' name='nationality' id='nationality' value='"+ bean.getNationality()+"' placeholder='Nationality'>");
		out.println("  </div>");
		out.println("</div>");
		out.println(" <div class='form-row'>");
		out.println("  <div class='form-group col-md-6'>");
		out.println(" <label for='inputEmail4'>Email</label>");
		out.println("<input type='email' class='form-control' name='email' value='"+ bean.getEmail()+"' id='inputEmail4' placeholder='Email'>");
		out.println(" </div>");
		out.println("<div class='form-group col-md-6'>");
		out.println("  <label for='mobile'>Mobile</label>");
		out.println(" <input type='text' class='form-control' name='mobile' value='"+ bean.getMobile()+"' id='mobile' placeholder='mobile'>");
		out.println(" </div>");
		out.println(" </div>");

		out.println(" <h4>Employee Address Details</h4>");
		out.println("<div class='form-group'>");
		out.println("<label for='inputAddress'>Address</label>");
		out.println("<input type='text' class='form-control' name='address' value='"+ bean.getAddress()+" 'id='inputAddress' placeholder='Address'>");
		out.println(" </div>");
		out.println("<div class='form-row'>");
		out.println("<div class='form-group col-md-4'>");
		out.println("<label for='inputCity'>City</label>");
		out.println(" <input type='text' name='city' class='form-control' value='"+ bean.getCity()+"'id='inputCity' placeholder='City'>");
		out.println("</div>");
		out.println(" <div class='form-group col-md-4'>");
		out.println("  <label for='inputState'>State</label>");
		out.println("<select id='inputState' class='form-control' name='state' >");
		out.println(" <option value='"+ bean.getState()+"'></option>");
		out.println("<option value='Karnataka'>Karnataka</option>");
		out.println("<option value='Andrapradesh'>Andrapradesh</option>");
		out.println("  <option value='Delhi'>Delhi</option>");
		out.println("  <option value='Chennai'>Chennai</option>");
		out.println(" <option value='Mumbai'>Mumbai</option>");
		out.println(" </select>");
		out.println(" </div>");
		out.println("<div class='form-group col-md-4'>");
		out.println(" <label for='inputZip'>Zip</label>");
		out.println("<input type='text' class='form-control' name='pincode' value='"+ bean.getPincode()+"' id='inputZip' placeholder='Pin Code'>");
		out.println("</div>");
		out.println("</div>");
		out.println("<h4>Employee Login Details</h4>");
		out.println("<div class='form-row'>");
		out.println(" <div class='form-group col-md-4'>");
		out.println(" <label for='uname'>User Name</label>");
		out.println("<input type='text' class='form-control' name='uname' value='"+ bean.getUname()+"' id='uname' placeholder='UserName'>");
		out.println(" </div>");
		out.println(" <div class='form-group col-md-4'>");
		out.println(" <label for='password'>Password </label>");
		out.println(" <input type='password' class='form-control' name='password' value='"+ bean.getPassword()+"' id='password' placeholder='Password'>");
		out.println("</div>");
		out.println(" <div class='form-group col-md-4'>");
		out.println(" <label for='cpassword'>Confirm-Password</label>");
		out.println(" <input type='password' class='form-control' name='cpassword' id='cpassword' placeholder='Re-Enter password'>");
		out.println(" </div>");
		out.println(" </div>");

		out.println("<div class='form-row'>");
		out.println("<div class='form-group col-md-4'>");
		out.println("<button type='submit' class='btn btn-primary'>Update</button>");
		out.println(" </div>");
		out.println("<div class='form-group col-md-4'>");
		out.println("  <button type='reset' class='btn btn-primary' >Reset</button>");
		out.println("</div>");
		out.println(" </div> ");

		out.println("</form>");

		

		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}
