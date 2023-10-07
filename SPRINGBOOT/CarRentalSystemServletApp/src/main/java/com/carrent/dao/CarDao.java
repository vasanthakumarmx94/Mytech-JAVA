package com.carrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.carrent.beans.CarBean;
import com.carrent.beans.CarBookingBean;



public class CarDao {

	public static int Carsave(CarBean bean){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into cars(carname,cartype,carcompany,carcity,carnumber,priceperday,cardescription,issustatus) values(?,?,?,?,?,?,?,?)");
			ps.setString(1,bean.getCarname());
			ps.setString(2,bean.getCartype());
			ps.setString(3,bean.getCarcompany());
			ps.setString(4,bean.getCarcity());
			ps.setString(5, bean.getCarnumaber());
			ps.setDouble(6,bean.getPriceperday());
			ps.setString(7,bean.getCardescription());
			ps.setString(8,"Available");
			
			
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<CarBean> viewavailablecar() {
		List<CarBean> list = new ArrayList<CarBean>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from cars where issustatus in('Available') ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				CarBean bean = new CarBean();

				bean.setId(rs.getInt("cid"));
				bean.setCarname(rs.getString("carname"));
				bean.setCartype(rs.getString("cartype"));
				bean.setCarcompany(rs.getString("carcompany"));
				bean.setCarcity(rs.getString("carcity"));
				bean.setCarnumaber(rs.getString("carnumber"));
				bean.setCardescription(rs.getString("cardescription"));
				bean.setPriceperday(Double.parseDouble(rs.getString("priceperday")));
				bean.setIssustatus(rs.getString("issustatus"));
				

				list.add(bean);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}
	
	public static int finduserbymail(String email) {
		int userid=0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where where email=? ");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CarBookingBean bean = new CarBookingBean();
				bean.setUserid(rs.getInt("uid"));
				userid=bean.getUserid();
				break;
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return userid;
		
	}
	
	
	public static int Bookmycar(CarBookingBean bean,String email){
		int status=0;
		try{
			
			int userid=finduserbymail(email);
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into carbook(carid,name,mobile,email,fromdate,todate,pickupaddress,dropaddress,userid) values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,bean.getCarid());
			ps.setString(2,bean.getFullname());
			ps.setString(3,bean.getMobile());
			ps.setString(4,bean.getEmail());
			ps.setString(5, bean.getFdate());
			ps.setString(6,bean.getTdate());
			ps.setString(7,bean.getPaddress());
			ps.setString(8,bean.getDaddress());
			ps.setInt(9,userid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int updatecarbooking(int carid) {
		int status=0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("update cars set issustatus=? where cid=? ");
			ps.setString(1, "Not Available");
			ps.setInt(2, carid);
			status=ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
}
