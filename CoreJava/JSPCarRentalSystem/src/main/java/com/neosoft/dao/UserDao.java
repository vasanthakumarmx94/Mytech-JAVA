package com.neosoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.neosoft.beans.UserBean;

public class UserDao {

	public static int Usersave(UserBean bean) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into users(name,mobile,state,city,pincode,address,email,password) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getMobile());
			ps.setString(3, bean.getState());
			ps.setString(4, bean.getCity());
			ps.setString(5, bean.getPincode());
			ps.setString(6, bean.getAddress());
			ps.setString(7, bean.getEmail());
			ps.setString(8, bean.getPassword());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<UserBean> getAllUsers() {

		List<UserBean> users = new ArrayList<UserBean>();
		try {

			Connection con = DB.getConnection();
			PreparedStatement pst;
			String selectequery = "select * from users";
			pst = con.prepareStatement(selectequery);

			// System.out.println("student inserted sucess");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUserid(rs.getInt("userid"));
				user.setName(rs.getString("name"));
				user.setMobile(rs.getString("mobile"));
				user.setState(rs.getString("state"));
				user.setCity(rs.getString("city"));
				user.setPincode(rs.getString("pincode"));
				user.setAddress(rs.getString("pincode"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;

	}

	public static int deleteUser(UserBean user) {
		int status = 0;
		try {

			Connection con = DB.getConnection();
			PreparedStatement pst;
			String deletequery = "DELETE from users where userid=?";
			pst = con.prepareStatement(deletequery);
			pst.setInt(1, user.getUserid());

			// System.out.println("student inserted sucess");
			status = pst.executeUpdate();
			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean userauthenticate(String email, String password) {
		boolean status = false;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	
	public static UserBean getUserByMail(String email) {
		UserBean user = new UserBean();
		//List<UserBean> users = new ArrayList<UserBean>();
		try {

			Connection con = DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where email=?");;
			ps.setString(1, email);
			// System.out.println("student inserted sucess");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				user.setUserid(rs.getInt("userid"));
				user.setName(rs.getString("name"));
				user.setMobile(rs.getString("mobile"));
				user.setState(rs.getString("state"));
				user.setCity(rs.getString("city"));
				user.setPincode(rs.getString("pincode"));
				user.setAddress(rs.getString("pincode"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}
	
	
	
	
	

}
