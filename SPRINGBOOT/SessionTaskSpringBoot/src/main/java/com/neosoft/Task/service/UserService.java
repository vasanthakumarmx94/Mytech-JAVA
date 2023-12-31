package com.neosoft.Task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.neosoft.Task.model.User;



@Service
@CacheConfig(cacheNames = "users")
public class UserService {

	private List<User> users = new ArrayList<User>(
			Arrays.asList(new User(101, "Akash", "vasu123"), new User(102, "Ram", "ram123"),
					new User(103, "karthik", "karthik123"), new User(104, "venky", "venky123")));

	public List<User> getUsers() {
		return users;
	}

	public User getUser(int id) {
		return users.stream().filter(u -> u.getUid() == id).findFirst().get();

	}

	public void addUser(User user) {
		users.add(user);
	}

	public void deleteUser(int id) {
		users.removeIf(u -> u.getUid() == id);
	}

	public void updateUser(User user, int id) {
		users.replaceAll(u -> {
			if (u.getUid() == id)
				u = user;
			return u;
		});
	}
	// SortByuname

	public List<User> sotingByUname() {

		Comparator<User> byNameComparator = Comparator.comparing(User::getUname);
		return users.stream().sorted(byNameComparator).collect(Collectors.toList());

//		return users.stream()
//				.sorted(Comparator.comparing(User::getUname))
//				.collect(Collectors.toList());
	}

	// SortByUid
	public List<User> sotingByuid() {
		Comparator<User> byNameComparator = Comparator.comparing(User::getUid);
		return users.stream().sorted(byNameComparator).collect(Collectors.toList());
	}

	// SortBypassword
	public List<User> sotingByupass() {
		Comparator<User> byNameComparator = Comparator.comparing(User::getUpass);
		return users.stream().sorted(byNameComparator).collect(Collectors.toList());
	}

	// search user by uname
		public User searchuserbyuname(String uname) {
			return users.stream().filter(u -> u.getUname().equals(uname)).findFirst().get();
		}
	
	
	
	
	
	// ============Testing spring boot cache=================
	@Cacheable //
	public List<User> findAll() {
		slowService(); // waits 3 second before execute find all
		return this.users;
	}

	private void slowService() {
		try {
			Thread.sleep(3000L);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
