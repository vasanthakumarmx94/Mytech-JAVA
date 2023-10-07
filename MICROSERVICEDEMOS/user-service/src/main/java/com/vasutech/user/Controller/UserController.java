package com.vasutech.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasutech.user.Entity.User;
import com.vasutech.user.Service.UserService;
import com.vasutech.user.VO.ResponsTemplateVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User SaveUser(@RequestBody User user) {
		log.info("Save user in user controller");
		return userService.saveUser(user);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponsTemplateVo getUserWithDepartment(@PathVariable long id) {
		
		
		return userService.getUserwithDepartment(id);
	}
	
	
	
	
	
	
	
	
	
}
