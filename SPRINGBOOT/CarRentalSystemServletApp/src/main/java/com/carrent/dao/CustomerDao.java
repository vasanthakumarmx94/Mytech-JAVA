package com.carrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.carrent.beans.CustomerBean;
import com.carrent.beans.UserBean;


public class CustomerDao {

	public static int Customersave(CustomerBean bean) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into customers(customer_name,customer_mobile,customer_email,city,state,pincode,address) values(?,?,?,?,?,?,?)");
			ps.setString(1, bean.getCusname());
			ps.setString(2, bean.getCusmobile());
			ps.setString(3, bean.getCusemail());
			ps.setString(4, bean.getCuscity());
			ps.setString(5, bean.getCusstate());
			ps.setString(6, bean.getCuspin());
			ps.setString(7, bean.getCusaddress());

			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	
	
	public static int CustomerRegister(UserBean bean) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into user(name,user_mobile,email,password,state,city,pincode,address) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getMobile());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getState());
			ps.setString(6, bean.getCity());
			ps.setString(7, bean.getPincode());
			ps.setString(8, bean.getAddress());

			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	
	
	public static boolean userauthenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	
	
	
	
}
