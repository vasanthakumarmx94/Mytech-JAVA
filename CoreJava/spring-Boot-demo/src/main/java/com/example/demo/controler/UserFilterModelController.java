package com.example.demo.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserFilterModel;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class UserFilterModelController {

	private List<UserFilterModel> users=new ArrayList<UserFilterModel>(Arrays.asList(
			
			new UserFilterModel("vasu","vasu123",22),
			new UserFilterModel("raam","raam123",23),
			new UserFilterModel("Raghu","Ragu123",21),
			new UserFilterModel("bhuvan","bhuvan123",23),
			new UserFilterModel("tippu","tippu123",22)
			));
	
	//tested static filter
	
//	@GetMapping("/userfilter")
//	public List<UserFilterModel> getAlluserFilter(){
//		return users;
//	}
//	
	
	
	
	//dynamic filter for every service
	@GetMapping("/userfilter/age")  // applying dynomic filter for all except age
	public MappingJacksonValue getAlluserFilterAge(){
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("age");
		FilterProvider filters=new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(users);
			mapping.setFilters(filters);
		return mapping;
	}
	
	
	
	@GetMapping("/userfilter/ageAndname")  // applying dynomic filter for all except age
	public MappingJacksonValue getAlluserFilterAgeandname(){
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("age","username");
		FilterProvider filters=new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(users);
		mapping.setFilters(filters);
		return mapping;
	}
	
}
