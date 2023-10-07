package com.neosoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.beans.CarBean;
import com.neosoft.beans.CarBookingBean;

public class CarDao {

	public static int Carsave(CarBean bean) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into cars(carname,cartype,carcompany,carcity,carnumber,priceperday,cardescription,issustatus) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, bean.getCarname());
			ps.setString(2, bean.getCartype());
			ps.setString(3, bean.getCarcompany());
			ps.setString(4, bean.getCarcity());
			ps.setString(5, bean.getCarnumaber());
			ps.setDouble(6, bean.getPriceperday());
			ps.setString(7, bean.getCardescription());
			ps.setString(8, "Available");
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public static int UpdateCar(CarBean bean) {
		int status = 0;
		try {
		Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update cars set carname=?,cartype=?,carcompany=?,carcity=?,carnumber=?,priceperday=?,cardescription=?,issustatus=? where cid=?");
			ps.setString(1, bean.getCarname());
			ps.setString(2, bean.getCartype());
			ps.setString(3, bean.getCarcompany());
			ps.setString(4, bean.getCarcity());
			ps.setString(5, bean.getCarnumaber());
			ps.setDouble(6, bean.getPriceperday());
			ps.setString(7, bean.getCardescription());
			ps.setString(8, bean.getIssustatus());
			ps.setInt(9, bean.getId());
			status = ps.executeUpdate();
			System.out.println(status);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
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
		int userid = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where email=? ");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CarBookingBean bean = new CarBookingBean();
				bean.setUserid(rs.getInt("userid"));
				userid = bean.getUserid();
				break;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return userid;
	}
	
	
	public static double getperdayprice(int carid) {
		double price = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from cars where cid=? ");
			ps.setInt(1, carid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CarBookingBean bean = new CarBookingBean();
				bean.setAmount(rs.getDouble("priceperday"));
				price = bean.getAmount();
				break;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return price;
	}
	
	

	public static int Bookmycar(CarBookingBean bean, String email, int carid) {
		int status = 0;
		try {
			String fdate=bean.getFdate();
			String tdate=bean.getTdate();
			
			LocalDate fdate1 = LocalDate.parse(fdate);
			LocalDate tdate1 = LocalDate.parse(tdate);
			 long days = ChronoUnit.DAYS.between(fdate1, tdate1);
			 double price=getperdayprice(carid);
			 double amount=days*price;
			int userid = finduserbymail(email);
			if (userid > 0) {
				Connection con = DB.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into carbook(carid,name,mobile,email,fromdate,todate,pickupaddress,dropaddress,userid,amount,returnstatus) values(?,?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, bean.getCarid());
				ps.setString(2, bean.getFullname());
				ps.setString(3, bean.getMobile());
				ps.setString(4, bean.getEmail());
				ps.setString(5, bean.getFdate());
				ps.setString(6, bean.getTdate());
				ps.setString(7, bean.getPaddress());
				ps.setString(8, bean.getDaddress());
				ps.setInt(9, userid);
				ps.setDouble(10, amount);
				ps.setString(11, "No");
				status = ps.executeUpdate();
				if (status > 0) {
					PreparedStatement ps1 = con.prepareStatement("update cars set issustatus=? where cid=? ");
					ps1.setString(1, "Not Available");
					ps1.setInt(2, carid);
					ps1.executeUpdate();
					con.close();
				}
				con.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	

	public static int updatecarbooking(int carid) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("update cars set issustatus=? where cid=? ");
			ps.setString(1, "Not Available");
			ps.setInt(2, carid);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	

	public static List<CarBean> getAllCars() {
		List<CarBean> cars = new ArrayList<CarBean>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement pst;
			String selectequery = "select * from cars";
			pst = con.prepareStatement(selectequery);

			// System.out.println("student inserted sucess");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				CarBean car = new CarBean();
				car.setId(rs.getInt("cid"));
				car.setCarname(rs.getString("carname"));
				car.setCartype(rs.getString("cartype"));
				car.setCarcompany(rs.getString("carcompany"));
				car.setCarcity(rs.getString("carcity"));
				car.setCarnumaber(rs.getString("carnumber"));
				car.setCardescription(rs.getString("cardescription"));
				car.setPriceperday(rs.getDouble("priceperday"));
				car.setIssustatus(rs.getString("issustatus"));
				cars.add(car);
			}
			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;

	}

	public static int deleteCar(CarBean car) {
		int status = 0;
		try {

			Connection con = DB.getConnection();
			PreparedStatement pst;
			String deletequery = "DELETE from cars where cid=?";
			pst = con.prepareStatement(deletequery);
			pst.setInt(1, car.getId());

			// System.out.println("student inserted sucess");
			status = pst.executeUpdate();
			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	
	public static CarBean getCarById(int carid) {
		CarBean car = new CarBean();
		// List<CarBean> cars = new ArrayList<CarBean>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from cars where cid=?");
			pst.setInt(1, carid);
			// System.out.println("student inserted sucess");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				car.setId(rs.getInt("cid"));
				car.setCarname(rs.getString("carname"));
				car.setCartype(rs.getString("cartype"));
				car.setCarcompany(rs.getString("carcompany"));
				car.setCarcity(rs.getString("carcity"));
				car.setCarnumaber(rs.getString("carnumber"));
				car.setCardescription(rs.getString("cardescription"));
				car.setPriceperday(rs.getDouble("priceperday"));
				car.setIssustatus(rs.getString("issustatus"));
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}
	
	
	public static List<CarBookingBean> viewMyBooking(int userid) {
		List<CarBookingBean> list = new ArrayList<CarBookingBean>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from carbook where userid=?");
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CarBookingBean bean = new CarBookingBean();
				bean.setBookingid(rs.getInt("bookingid"));
				bean.setCarid(rs.getInt("carid"));
				bean.setFullname(rs.getString("name"));
				bean.setMobile(rs.getString("mobile"));
				bean.setEmail(rs.getString("email"));
				bean.setFdate(rs.getString("fromdate"));
				bean.setTdate(rs.getString("todate"));
				bean.setPaddress(rs.getString("pickupaddress"));
				bean.setDaddress(rs.getString("dropaddress"));
				bean.setUserid(rs.getInt("userid"));
				bean.setAmount(Double.parseDouble(rs.getString("amount")));
				bean.setReturnstatus(rs.getString("returnstatus"));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	public static List<CarBookingBean> ViewAllBooking() {
		List<CarBookingBean> list = new ArrayList<CarBookingBean>();
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from carbook");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CarBookingBean bean = new CarBookingBean();
				bean.setBookingid(rs.getInt("bookingid"));
				bean.setCarid(rs.getInt("carid"));
				bean.setFullname(rs.getString("name"));
				bean.setMobile(rs.getString("mobile"));
				bean.setEmail(rs.getString("email"));
				bean.setFdate(rs.getString("fromdate"));
				bean.setTdate(rs.getString("todate"));
				bean.setPaddress(rs.getString("pickupaddress"));
				bean.setDaddress(rs.getString("dropaddress"));
				bean.setUserid(rs.getInt("userid"));
				bean.setAmount(Double.parseDouble(rs.getString("amount")));
				bean.setReturnstatus(rs.getString("returnstatus"));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	
	public static int ReturnMyCar(int bookingid) {
		int status1 = 0;
		try {
				Connection con = DB.getConnection();
				PreparedStatement ps = con.prepareStatement("update carbook set returnstatus=? where bookingid=?");
				ps.setString(1,"Yes");
				ps.setInt(2,bookingid);
				int status = ps.executeUpdate();
				int cid=0;
				if (status > 0) {
					PreparedStatement ps1 = con.prepareStatement("select * from carbook where bookingid=?");
					ps1.setInt(1, bookingid);
					ResultSet rs = ps1.executeQuery();
					while(rs.next()) {
						cid=rs.getInt("carid");
					}
					PreparedStatement ps2 = con.prepareStatement("update cars set issustatus=? where cid=? ");
					ps2.setString(1, "Available");
					ps2.setInt(2, cid);
					status1=ps2.executeUpdate();
					con.close();
				}
				con.close();	
		} catch (Exception e) {
			System.out.println(e);
		}
		return status1;
	}

}
