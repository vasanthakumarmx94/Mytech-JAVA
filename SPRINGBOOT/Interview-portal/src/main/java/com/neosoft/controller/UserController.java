package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.User;
import com.neosoft.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	
	@Autowired 
	private UserService userService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user/register")
	public void registerUser(@RequestBody User user) {
		userService.RegisterUser(user);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/signin/{email}/{password}")
	public ResponseEntity<User> findUserByEmailAndPassword(@PathVariable String email,@PathVariable String password) {
		
		User user = userService.getUserByEmailAndPassword(email,password);
		return ResponseEntity.ok(user);
	}
	
	
	
	
	

}
