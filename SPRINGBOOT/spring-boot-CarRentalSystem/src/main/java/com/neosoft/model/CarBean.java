package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="cars")
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("CarsBeanFilter")  // dynamic filter service level
public class CarBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="car_id")
	private Long carid;
	
	private String carname;
	private String carcompany;
	private String carcity;
	private String carnumaber;
	private String cardescription;
	private String issustatus;
	private double priceperday;
	public Long getCarid() {
		return carid;
	}
	public void setCarid(Long carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
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
	public String getIssustatus() {
		return issustatus;
	}
	public void setIssustatus(String issustatus) {
		this.issustatus = issustatus;
	}
	public double getPriceperday() {
		return priceperday;
	}
	public void setPriceperday(double priceperday) {
		this.priceperday = priceperday;
	}
	
	
	
	
	
}
