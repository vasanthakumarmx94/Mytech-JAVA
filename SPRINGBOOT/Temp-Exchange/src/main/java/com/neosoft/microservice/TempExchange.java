package com.neosoft.microservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TempExchange {

	@Id
	private Long id;
	
	@Column(name="temp_from")
	private String from;
	
	
	@Column(name="temp_to")
	private String to;
	
	private BigDecimal conversionMultiple;
	
	private String environment;
	
}
