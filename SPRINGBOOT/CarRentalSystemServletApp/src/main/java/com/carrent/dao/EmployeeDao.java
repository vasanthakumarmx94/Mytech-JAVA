package com.carrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.carrent.beans.EmployeeBean;


public class EmployeeDao {

	public static int Employeesave(EmployeeBean bean) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into employee(empfname,empmname,emplname,gender,date_Of_birth,nationality,email,mobile,address,city,state,pincode,username,password) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, bean.getFirstname());
			ps.setString(2, bean.getMiddlename());
			ps.setString(3, bean.getLastname());
			ps.setString(4, bean.getGender());
			ps.setString(5, bean.getDate());
			ps.setString(6, bean.getNationality());
			ps.setString(7, bean.getEmail());
			ps.setString(8, bean.getMobile());
			ps.setString(9, bean.getAddress());
			ps.setString(10, bean.getCity());
			ps.setString(11, bean.getState());
			ps.setString(12, bean.getPincode());
			ps.setString(13, bean.getUname());
			ps.setString(14, bean.getPassword());

			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static List<EmployeeBean> viewall() {
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				EmployeeBean bean = new EmployeeBean();

				bean.setEmpid(rs.getInt("empid"));
				bean.setFirstname(rs.getString("empfname"));
				bean.setMiddlename(rs.getString("empmname"));
				bean.setLastname(rs.getString("emplname"));
				bean.setGender(rs.getString("gender"));
				bean.setDate(rs.getString("date_Of_birth"));
				bean.setNationality(rs.getString("nationality"));
				bean.setEmail(rs.getString("email"));
				bean.setMobile(rs.getString("mobile"));
				bean.setAddress(rs.getString("address"));
				bean.setCity(rs.getString("city"));
				bean.setState(rs.getString("state"));
				bean.setPincode(rs.getString("pincode"));
				bean.setUname(rs.getString("username"));
				bean.setPassword(rs.getString("password"));

				list.add(bean);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public static EmployeeBean viewById(int id) {
		EmployeeBean bean = new EmployeeBean();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee where empid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				/*
				 * bean.setId(rs.getInt(1)); bean.setName(rs.getString(2));
				 * bean.setPassword(rs.getString(3)); bean.setEmail(rs.getString(4));
				 * bean.setMobile(rs.getLong(5));
				 */

				bean.setEmpid(rs.getInt("empid"));
				bean.setFirstname(rs.getString("empfname"));
				bean.setMiddlename(rs.getString("empmname"));
				bean.setLastname(rs.getString("emplname"));
				bean.setGender(rs.getString("gender"));
				bean.setDate(rs.getString("date_Of_birth"));
				bean.setNationality(rs.getString("nationality"));
				bean.setEmail(rs.getString("email"));
				bean.setMobile(rs.getString("mobile"));
				bean.setAddress(rs.getString("address"));
				bean.setCity(rs.getString("city"));
				bean.setState(rs.getString("state"));
				bean.setPincode(rs.getString("pincode"));
				bean.setUname(rs.getString("username"));
				bean.setPassword(rs.getString("password"));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return bean;
	}
	
	
	
	public static int Employeeupdate(EmployeeBean bean) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update employee set empfname=?,empmname=?,emplname=?,gender=?,date_Of_birth=?,nationality=?,email=?,mobile=?,address=?,city=?,state=?,pincode=?,username=?,password=? where empid=? ");

			ps.setString(1, bean.getFirstname());
			ps.setString(2, bean.getMiddlename());
			ps.setString(3, bean.getLastname());
			ps.setString(4, bean.getGender());
			ps.setString(5, bean.getDate());
			ps.setString(6, bean.getNationality());
			ps.setString(7, bean.getEmail());
			ps.setString(8, bean.getMobile());
			ps.setString(9, bean.getAddress());
			ps.setString(10, bean.getCity());
			ps.setString(11, bean.getState());
			ps.setString(12, bean.getPincode());
			ps.setString(13, bean.getUname());
			ps.setString(14, bean.getPassword());
			ps.setInt(15, bean.getEmpid());
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	
	
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from employee where empid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

}
