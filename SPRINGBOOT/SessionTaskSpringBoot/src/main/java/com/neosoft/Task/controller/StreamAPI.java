package com.neosoft.Task.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.Task.service.StreamServiceImpl;

@RestController
@Validated
@RequestMapping(value = "/stream-api")
public class StreamAPI {

	
	@Autowired 
	StreamServiceImpl streamService; 
	
	 @Autowired
	 private Environment environment;
	
	//----------------next method definition
	 
	 //here @postMapping
	 
	 //
	 
	 @DeleteMapping(value = "student/{studentId}")
	    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) throws Exception {
		 streamService.deleteStudent(studentId);
	        return new ResponseEntity<>(environment.getProperty("API.STUDENT_DELETE_SUCCESS"), HttpStatus.OK);
	    }
	
	
}
