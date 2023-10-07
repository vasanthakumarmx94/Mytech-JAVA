package com.tech.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tech.model.User;

public class GroupUserDetails implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;
	
	public GroupUserDetails(User user) {
		this.username=user.getEmail();
		this.password=user.getPassword();
		this.isActive=user.isStatus();
		this.authorities=Arrays.stream(user.getRole().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return isActive;
	}

}
