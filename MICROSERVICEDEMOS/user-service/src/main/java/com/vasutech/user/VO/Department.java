package com.vasutech.user.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	private long departmentId;
	
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
