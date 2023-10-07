package com.neosoft.serviceTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.tech.model.Experience;
import com.tech.model.User;
import com.tech.repository.UserRepository;
import com.tech.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
    private UserRepository userRepository;
	
    @Autowired
    @InjectMocks
    private UserService userService;
    
    
    private User user1;
    private User user2;
    List<User> userList;
    
    @BeforeEach
    public void setUp() {
    	Experience experience=new Experience(2L,"1-2years",1);
    	
    	userList = new ArrayList<>();
    	user1 = new User(1L, "admin","admin","admin@gmail.com","admin","8787999877","admin",true,experience);
    	user2 = new User(1L, "Ram","kumar","Ram@gmail.com","Ram@123","8787999877","ROLE_USER",true,experience);
    	userList.add(user1);
    	userList.add(user2);
    }
    
    @AfterEach
    public void tearDown() {
    	user1 = user2 = null;
    	userList = null;
    }
    
    
    @Test
    void givenUserReturnRegisterdUser() {
         //stubbing
         //when(userRepository.save(any())).thenReturn(user1);
         userService.RegisterUser(user1);
         verify(userRepository,times(1)).save(user1);
         
    }
	
    @Test
    public void GivenGetAllUsersShouldReturnListOfAllUsers(){
    	userRepository.save(user1);
        //stubbing mock to return specific data
        when(userRepository.findAll()).thenReturn(userList);
        List<User> userList1 =userService.getAllUsers();
        assertEquals(userList1,userList);
        verify(userRepository,times(1)).save(user1);
        verify(userRepository,times(1)).findAll();
    }
    
    @Test
    public void givenIDThenShouldReturnUserOfThatID() {
    
    	   Mockito.when(userRepository.findById((long) 1)).thenReturn(Optional.ofNullable(user1));
    	   assertThat(userService.getUserById(user1.getId())).isEqualTo(user1);
    	
		
    }
    
    @Test
    public void givenEmailThenShouldReturnUserOfThatEMail() {
    	   Mockito.when(userRepository.findByEmail("admin@gmail.com")).thenReturn(Optional.ofNullable(user1));
    	   assertThat(userService.getUserByEmail(user1.getEmail()).get()).isEqualTo(user1);
    		
    }
    
    
	
}
