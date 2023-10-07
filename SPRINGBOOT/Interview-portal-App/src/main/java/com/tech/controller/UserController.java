package com.tech.controller;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.User;
import com.tech.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	private static final String DEFAULT_ROLE = "ROLE_USER";
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/")
	public String login() {
		return "authentication Successfully";
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		user.setStatus(true);
		user.setRole(DEFAULT_ROLE); // USER
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userService.RegisterUser(user);
		return ResponseEntity.ok(user);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/signin/{email}/{password}")
	public ResponseEntity<User> findUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		User user = userService.getUserByEmailAndPassword(email, password);
		return ResponseEntity.ok(user);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getuserbyMail/{email}")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
		User user = userService.getUserByEmail(email).get();
		return ResponseEntity.ok(user);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getuserbyId/{id}")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	public ResponseEntity<User> findUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update-user/{id}")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	public void updateUser(@RequestBody User userReq, @PathVariable long id) {
		
		
		User user = userService.getUserById(id);
		String encryptedPassword = passwordEncoder.encode(userReq.getPassword());
		user.setPassword(encryptedPassword);
		user.setFirstName(userReq.getFirstName());
		user.setLastName(userReq.getLastName());
		user.setEmail(userReq.getEmail());
		user.setContactNo(userReq.getContactNo());
		user.setRole(userReq.getRole());
		user.setExperience(userReq.getExperience());
		
		userService.updateUser(user);
		
		logger.info("/PUT a UserUpdateProfile Logger method:"+new java.util.Date().toString());
	}
	
	
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	public Principal user(Principal user) {
		return user;
	}

}
