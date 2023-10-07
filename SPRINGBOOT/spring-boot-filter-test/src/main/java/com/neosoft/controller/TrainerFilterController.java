package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.neosoft.model.Trainer;
import com.neosoft.repository.TrainerRepository;

@RestController
public class TrainerFilterController {

	@Autowired 
	private TrainerRepository trainerRepository;
	
	@GetMapping("/trainerfilter")
	public List<Trainer> getAlltrainerFilter(){
		return trainerRepository.findAll();
	}
	
	
	//dynamic filter for every service
		@GetMapping("/trainerfilter/course")  // applying dynomic filter for all except age
		public MappingJacksonValue getAlltrainerCourse(){
			 List<Trainer> trainer=trainerRepository.findAll();
			 //Object[] trainers=trainer.toArray();
			SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("tcourse");
			FilterProvider filters=new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
			MappingJacksonValue mapping=new MappingJacksonValue(trainer);
				mapping.setFilters(filters);
			return mapping;
		}
		
		
		//dynamic filter for every service
				@GetMapping("/trainerfilter/coursefeesname")  // applying dynomic filter for all except age
				public MappingJacksonValue getAllTrainerCourseAndFeesAndName(){
					 List<Trainer> trainer=trainerRepository.findAll();
					// Object[] trainers=trainer.toArray();
					SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("tcourse","tfees","tname");
					FilterProvider filters=new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
					MappingJacksonValue mapping=new MappingJacksonValue(trainer);
						mapping.setFilters(filters);
					return mapping;
				}
				
				@PostMapping("/addtrainer")
				public void addTrainer(@RequestBody Trainer trainer) {
					trainerRepository.save(trainer);
				}
				
				
				
				
				
}
