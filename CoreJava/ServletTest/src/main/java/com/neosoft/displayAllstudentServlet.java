package com.neosoft;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;
import com.neosoft.controler.StudentController;
import com.neosoft.model.Student;

@WebServlet(urlPatterns = "/displayall")
public class displayAllstudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.setContentType("text/html");
		
		List<Student> lst=StudentController.getAllStudents();
		Gson json = new Gson();
		
		String responsejsonstring=json.toJson(lst);
		//PrintWriter response=resp.getWriter();
			PrintWriter out=resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");

			resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			resp.setContentType("application/json");
			out.println(responsejsonstring);
			out.flush();
		
       
		
//		for (Student student : lst) {
//			
//			out.println(student);
//		}
		
		
	}
	
	
	

}
