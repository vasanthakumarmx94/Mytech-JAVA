package com.vasutech.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vasutech.user.Entity.User;
import com.vasutech.user.Repository.UserRepository;
import com.vasutech.user.VO.Department;
import com.vasutech.user.VO.ResponsTemplateVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("save user in sevice ");
		return userRepository.save(user);
	}

	public ResponsTemplateVo getUserwithDepartment(long id) {
		ResponsTemplateVo vo=new ResponsTemplateVo();
		User user=userRepository.findByUserId(id);
		
		Department department=restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(), Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
	
	
	
}
