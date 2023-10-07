package com.carrent.beans;

public class CarBean {

	private String carname,cartype, carcompany, carcity,carnumaber,cardescription,issustatus;
	double priceperday;
	int id;
	
	public CarBean() {
		super();
	}
	
	
	public CarBean(int id,String carname, String cartype, String carcompany, String carcity, String carnumaber,double priceperday,
			String cardescription) {
		super();
		this.id=id;
		this.carname = carname;
		this.cartype = cartype;
		this.carcompany = carcompany;
		this.carcity = carcity;
		this.carnumaber = carnumaber;
		this.cardescription = cardescription;
		this.priceperday = priceperday;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCarcompany() {
		return carcompany;
	}
	public void setCarcompany(String carcompany) {
		this.carcompany = carcompany;
	}
	public String getCarcity() {
		return carcity;
	}
	public void setCarcity(String carcity) {
		this.carcity = carcity;
	}
	public String getCarnumaber() {
		return carnumaber;
	}
	public void setCarnumaber(String carnumaber) {
		this.carnumaber = carnumaber;
	}
	public String getCardescription() {
		return cardescription;
	}
	public void setCardescription(String cardescription) {
		this.cardescription = cardescription;
	}
	public double getPriceperday() {
		return priceperday;
	}
	public void setPriceperday(double priceperday) {
		this.priceperday = priceperday;
	}
	
	public String getIssustatus() {
		return issustatus;
	}
	public void setIssustatus(String issustatus) {
		this.issustatus = issustatus;
	}
	
	
	
	
}
