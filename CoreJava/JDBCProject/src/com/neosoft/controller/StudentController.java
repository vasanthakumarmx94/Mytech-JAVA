package com.neosoft.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.model.Student;

public class StudentController {

	public static List<Student> getAllStudents(){
		List<Student> students=new ArrayList<Student>();
		Connection con=JDBCProperties.getConnection();
		
		try {
			String query="SELECT * FROM mydb.student";
			
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				
				students.add(new Student(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4)));
				
				//System.out.println("added sucess");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return students ;
		
	}
	
	
}
