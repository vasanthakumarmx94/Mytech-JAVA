package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	// we are injecting business service class
	@Autowired
	private UserService userService;
	
//	http://localhost:8085/users
	@GetMapping("/users")
	public List<User> getUser(){
		return userService.getUsers();
		
	}
	
//	http://localhost:8085/users/103
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
		}
	
	
	// http://localhost:8085/users
	// ad json text to add
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	// http://localhost:8085/users/102
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	// http://localhost:8085/users/102
	@PutMapping("/users/{id}")
	public void updateuser(@RequestBody User user,@PathVariable int id )
	{
		userService.updateUser(user, id);
	}
	
//	@PutMapping("/users/sortByUsername")
//	public List<User> sortbyname( )
//	{
//		return userService.sotingByUname();
//	}
//	@PutMapping("/users/sortByUid")
//	public List<User> sortbyid( )
//	{
//		return userService.sotingByuid();
//	}
	
}
