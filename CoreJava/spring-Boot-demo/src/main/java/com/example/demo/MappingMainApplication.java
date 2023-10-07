package com.example.demo;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Gender;
import com.example.demo.model.Users;
import com.example.demo.model.UsersProfile;
import com.example.demo.repository.UsersRepository;

@SpringBootApplication
public class MappingMainApplication implements CommandLineRunner{

//	@Autowired
//	private UsersRepository userRepository;
//	
	public static void main(String[] args) {

		//SpringApplication.run(MappingMainApplication.class, args);
		

	}

	@Override
	public void run(String... args) throws Exception {

//		// create users instance
//		Users user=new Users("abcd","xyz","abcd@gmail.com","abcd123");
//		
//		Calendar dob=Calendar.getInstance();
//		dob.set(1999,2,20);
//		UsersProfile userProfile=new UsersProfile("+91 8787666788",Gender.MALE,dob.getTime(),"A111","banglore","KA","india","4001");
//		
//		
//		// set child reference in parent entity
//		user.setUserprofile(userProfile);
//		
//		// set reference in child entity
//		userProfile.setUsers(user);
//		
//		//save parent reference also will save chilad ref as well
//		userRepository.save(user);
//		
//		
		
		
		
		
		
		
	}

}
