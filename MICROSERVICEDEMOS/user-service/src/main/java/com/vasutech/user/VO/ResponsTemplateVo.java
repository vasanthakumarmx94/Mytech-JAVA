package com.vasutech.user.VO;

import com.vasutech.user.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsTemplateVo {

	private User user;
	private Department department;
}
