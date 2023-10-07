package com.neosoft.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class UserController {

	public static int saveUser(User user) {
		int status=0;
		try {
			
			Connection con=JDBCProperties.getConnection();
			PreparedStatement pst;
			String insertquery = "insert into user(name,password,email,gender,country)values(?,?,?,?,?)";
			pst = con.prepareStatement(insertquery);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getCountry());
			
			// System.out.println("student inserted sucess");
			status= pst.executeUpdate();
			//System.out.print(status);
			pst.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static int UpdateUser(User user) {
		int status=0;
		try {
			
			Connection con=JDBCProperties.getConnection();
			PreparedStatement pst;
			String updatequery = "UPDATE User SET  name=?,password=?,email=?,gender=?,countrty=? where id=?";
			pst = con.prepareStatement(updatequery);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getCountry());
			pst.setInt(6, user.getId());
			
			
			// System.out.println("student inserted sucess");
			status= pst.executeUpdate();
			pst.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static int deleteUser(User user) {
		int status=0;
		try {
			
			Connection con=JDBCProperties.getConnection();
			PreparedStatement pst;
			String deletequery = "DELETE from user where id=?";
			pst = con.prepareStatement(deletequery);
			pst.setInt(1, user.getId());
			
			// System.out.println("student inserted sucess");
			status= pst.executeUpdate();
			pst.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static List<User> getAllUsers() {
		
		List<User> users=new ArrayList<User>();
		try {
			
			Connection con=JDBCProperties.getConnection();
			PreparedStatement pst;
			String selectequery = "select * from user";
			pst = con.prepareStatement(selectequery);
			
			// System.out.println("student inserted sucess");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setCountry(rs.getString("country"));
				users.add(user);
			}
			pst.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
		
	}
	
public static User getUsersById(int Id) {
		
		User user=null;
		try {
			
			Connection con=JDBCProperties.getConnection();
			PreparedStatement pst;
			String selectequery = "select * from user where id=?";
			pst = con.prepareStatement(selectequery);
			pst.setInt(1, Id);
			// System.out.println("student inserted sucess");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setCountry(rs.getString("country"));
				
			}
			pst.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	
	

}
