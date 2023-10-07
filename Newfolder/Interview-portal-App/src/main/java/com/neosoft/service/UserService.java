package com.neosoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.User;
import com.neosoft.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User RegisterUser(User user) {
		return userRepository.save(user);

	}

	public Optional<User> getUserById(long id) {
		return userRepository.findById(id);

	}
	public User getUserByEmailAndPassword(String email,String password) {
		return userRepository.findByEmailAndPassword(email,password);

	}
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);

	}

	public User updateUser(User user) {
		return userRepository.save(user);

	}


}
