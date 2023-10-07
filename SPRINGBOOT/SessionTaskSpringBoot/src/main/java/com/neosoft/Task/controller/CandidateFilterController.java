package com.neosoft.Task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.neosoft.Task.model.Candidate;
import com.neosoft.Task.repository.CandidateRepository;

@RestController
public class CandidateFilterController {

	
	@Autowired
	private CandidateRepository candidateRepository;
	
//	@GetMapping("/candidatefilter")
//	public List<Candidate> getAllCandidateFilter(){
//		return candidateRepository.findAll();
//	}
//	
	
	
	//dynamic filter for every service
			@GetMapping("/candidate/personal")  // applying dynomic filter for all except age
			public MappingJacksonValue getAllCandidatePersnal(){
				 List<Candidate> candidate=candidateRepository.findAll();
				SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("Cid","name","age");
				FilterProvider filters=new SimpleFilterProvider().addFilter("CandidateBeanFilter", filter);
				MappingJacksonValue mapping=new MappingJacksonValue(candidate);
					mapping.setFilters(filters);
				return mapping;
			}
			
			
			//dynamic filter for every service
			@GetMapping("/candidate/address")  // applying dynomic filter for all except age
			public MappingJacksonValue getAllCandidateAddress(){
				 List<Candidate> candidate=candidateRepository.findAll();
				SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("cid","city","state","country","pin");
				FilterProvider filters=new SimpleFilterProvider().addFilter("CandidateBeanFilter", filter);
				MappingJacksonValue mapping=new MappingJacksonValue(candidate);
					mapping.setFilters(filters);
				return mapping;
			}
	
			@PostMapping("/addcandidate")
			public void addTrainer(@RequestBody Candidate candidate) {
				candidateRepository.save(candidate);
			}
			
	
	
	
}
