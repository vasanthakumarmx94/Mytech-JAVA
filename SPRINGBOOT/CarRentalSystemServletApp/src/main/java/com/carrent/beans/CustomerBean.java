package com.carrent.beans;

public class CustomerBean {

	String cusname, cusmobile, cusemail, cuscity, cusstate, cuspin, cusaddress;
	int cusid;

	public CustomerBean() {
		super();
	}

	public CustomerBean(int cusid,String cusname, String cusmobile, String cusemail, String cuscity, String cusstate,
			String cuspin, String cusaddress) {
		super();
		this.cusid = cusid;
		this.cusname = cusname;
		this.cusmobile = cusmobile;
		this.cusemail = cusemail;
		this.cuscity = cuscity;
		this.cusstate = cusstate;
		this.cuspin = cuspin;
		this.cusaddress = cusaddress;
		
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getCusmobile() {
		return cusmobile;
	}

	public void setCusmobile(String cusmobile) {
		this.cusmobile = cusmobile;
	}

	public String getCusemail() {
		return cusemail;
	}

	public void setCusemail(String cusemail) {
		this.cusemail = cusemail;
	}

	public String getCuscity() {
		return cuscity;
	}

	public void setCuscity(String cuscity) {
		this.cuscity = cuscity;
	}

	public String getCusstate() {
		return cusstate;
	}

	public void setCusstate(String cusstate) {
		this.cusstate = cusstate;
	}

	public String getCuspin() {
		return cuspin;
	}

	public void setCuspin(String cuspin) {
		this.cuspin = cuspin;
	}

	public String getCusaddress() {
		return cusaddress;
	}

	public void setCusaddress(String cusaddress) {
		this.cusaddress = cusaddress;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

}
