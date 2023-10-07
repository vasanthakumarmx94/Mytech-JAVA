package com.neosoft.Task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.Task.model.User;
import com.neosoft.Task.service.UserService;



@RestController
public class UserController {
	
	// we are injecting business service class
	@Autowired
	private UserService userService;
	
//	http://localhost:8080/users
	@GetMapping("/user")
	public List<User> getUser(){
		return userService.getUsers();
		
	}
	
	
//	http://localhost:8080/users/103
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
		}
	
	
	// http://localhost:8080/users
	// ad json text to add
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	// http://localhost:8080/users/102
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	// http://localhost:8080/users/102
	@PutMapping("/userss/{id}")
	public void updateuser(@RequestBody User user,@PathVariable int id )
	{
		userService.updateUser(user, id);
	}
	
	// http://localhost:8080/users/sortByUsername
	@GetMapping("/users/sortByUsername")
	public List<User> sortbyname( )
	{
		return userService.sotingByUname();
	}
	
	// http://localhost:8080/users/sortByUid
	@GetMapping("/users/sortByUid")
	public List<User> sortbyid( )
	{
		return userService.sotingByuid();
	}
	
	// http://localhost:8080/users/sortByUpass
	@GetMapping("/users/sortByUpass")
	public List<User> sortbyupass( )
	{
		return userService.sotingByupass();
	}
	
	// http://localhost:8080/users/101
	@GetMapping("/userss/{uname}")
	public User searchUserByuname(@PathVariable String uname )
	{
		return userService.searchuserbyuname(uname);
	}
	
	
	
	//-===============testing spring boot cache=================
	// http://localhost:8080/all
	
	@GetMapping("/all")
	public List<User> getallusers(){
		return userService.findAll();
	}
	
}
