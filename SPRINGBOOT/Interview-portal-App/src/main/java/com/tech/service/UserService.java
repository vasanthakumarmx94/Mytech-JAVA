package com.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.model.User;
import com.tech.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User RegisterUser(User user) {
		return userRepository.save(user);

	}

	public User getUserById(long id) {
		return userRepository.findById(id).orElse(null);
	}
	public User getUserByEmailAndPassword(String email,String password) {
		return userRepository.findByEmailAndPassword(email,password);

	}
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);

	}

	public User updateUser(User user) {
		return userRepository.save(user);

	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}


}
