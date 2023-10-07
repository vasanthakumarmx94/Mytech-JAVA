package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserService {

	private List<User> users = new ArrayList<User>(Arrays.asList(
			new User(101, "Akash", "vasu123"),
			new User(102, "Ram", "ram123"), 
			new User(103, "karthik", "karthik123"),
			new User(104, "venky", "venky123")));

	public List<User> getUsers(){
		return users;
	}
	
	public User getUser(int id) {
		return users.stream().filter(u->u.getUid()==id).findFirst().get();
		
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(int id) {
		users.removeIf(u->u.getUid()==id);
	}
	
	public void updateUser(User user,int id)
	{
		users.replaceAll(u->{
			if(u.getUid()==id)
				u=user;
			return u;
		});
	}
	// SortByuname
	
//	public List<User> sotingByUname() {
//		
//		Comparator<User> byNameComparator = Comparator.comparing(User::getUname);
//		return users.stream().sorted(byNameComparator).collect(Collectors.toList());
//		
//	}
//	
//	// SortByUid
//	
//		public List<User> sotingByuid() {
//			
//			Comparator<User> byNameComparator = Comparator.comparing(User::getUid);
//			return users.stream().sorted(byNameComparator).collect(Collectors.toList());
//			
//		}

//	
}
