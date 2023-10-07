package com.neosoft.Task.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stream")
public class Stream {

	@Id
	private Integer straemId;
    private String straemName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer capacity;
	public Integer getStraemId() {
		return straemId;
	}
	public void setStraemId(Integer straemId) {
		this.straemId = straemId;
	}
	public String getStraemName() {
		return straemName;
	}
	public void setStraemName(String straemName) {
		this.straemName = straemName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	
	
	
}
