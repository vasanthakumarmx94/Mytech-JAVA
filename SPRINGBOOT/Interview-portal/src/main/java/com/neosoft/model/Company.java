package com.neosoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long id;
	
	@Size(max = 150)
	private String companyName;
	
	@Size(max = 300)
	private String profileDescription;
	
	@Temporal(TemporalType.DATE)
	@Column(name="establish_date")
	private Date establishDate; 
	
	@Size(max = 150)
	private String companyWebsite;
	
	@Size(max=300)
	private String jobDescription;
	
	private int active;
	
	

}
