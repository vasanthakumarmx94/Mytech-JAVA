package com.neosoft.Task.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.Task.myException.ResourceNotFoundException;
import com.neosoft.Task.model.Users;
import com.neosoft.Task.repository.UsersRepository;

@RestController
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

	// http://localhost:8080/users
	@GetMapping("/users")
	public List<Users> findallusers() {
		return usersRepository.findAll();

	}

	// http://localhost:8080/users/add
	@PostMapping("/users/add")
	public void addusers(@RequestBody Users user) {
		usersRepository.save(user);
	}

	// http://localhost:8080/users/1
	@DeleteMapping("/users/{id}")
	public void deleteusers(@PathVariable long id) {
		usersRepository.deleteById(id);
	}

	// http://localhost:8080/users/1
	@PutMapping("/users/{id}")
	public Users updateuser(@Valid @RequestBody Users userreq, @PathVariable long id) {
		if (!usersRepository.existsById(id))
			throw new ResourceNotFoundException("Users", "usersid", id);

		return usersRepository.findById(id).map(u -> {
			u.setFirstName(userreq.getFirstName());
			u.setLastName(userreq.getLastName());
			u.setUsername(userreq.getUsername());
			u.setPassword(userreq.getPassword());
			return usersRepository.save(u);
		}).orElseThrow(() -> new ResourceNotFoundException("user", "usersId", id));

	}

	// http://localhost:8080/users/sortbyuname
	@GetMapping("/users/sortbyuname")
	public List<Users> sortByUname() {
		List<Users> ulist = usersRepository.findAll();
		Comparator<Users> u = Comparator.comparing(Users::getUsername);
		return ulist.stream().sorted(u).collect(Collectors.toList());

	}

	// http://localhost:8080/users/sortbyupass
	@GetMapping("/users/sortbyupass")
	public List<Users> sortByUpass() {
		List<Users> ulist = usersRepository.findAll();
		Comparator<Users> u = Comparator.comparing(Users::getPassword);
		return ulist.stream().sorted(u).collect(Collectors.toList());

	}

	// http://localhost:8080/users/vasuraam
	@GetMapping("/users/{uname}")
	public Users getuserbyuname(@PathVariable String uname) {
		List<Users> ulist = usersRepository.findAll();
		return ulist.stream().filter(u -> u.getUsername().equals(uname)).findFirst().get();

	}

	// ============Testing spring boot cache=================
	// http://localhost:8080/allusers

//	@GetMapping("/allusers")
//	@Cacheable //
//	public List<Users> findAll() {
//		slowService(); // waits 3 second before execute find all
//		List<Users> users = usersRepository.findAll();
//		return users;
//	}
//
//	private void slowService() {
//		try {
//			Thread.sleep(3000L);
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

}
