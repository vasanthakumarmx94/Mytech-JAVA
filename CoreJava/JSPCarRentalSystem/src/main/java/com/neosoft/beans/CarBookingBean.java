package com.neosoft.beans;

public class CarBookingBean {

	int carid;
	String fullname,mobile,email,fdate,tdate,paddress,daddress,returnstatus;
	int userid,bookingid;
	double amount;
	

	public CarBookingBean() {
		super();
	}
	
	
	
	public CarBookingBean(int carid, String fullname, String mobile, String email, String fdate, String tdate,
			String paddress, String daddress) {
		super();
		this.carid = carid;
		this.fullname = fullname;
		this.mobile = mobile;
		this.email = email;
		this.fdate = fdate;
		this.tdate = tdate;
		this.paddress = paddress;
		this.daddress = daddress;
	}
	
	
	
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int uid) {
		this.userid = uid;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public String getDaddress() {
		return daddress;
	}
	public void setDaddress(String daddress) {
		this.daddress = daddress;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	
	
	
	
}
