package com.neosoft.mongo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.mongo.exception.ResourceNotFoundException;
import com.neosoft.mongo.model.Employee;
import com.neosoft.mongo.repository.EmployeeRepository;
import com.neosoft.mongo.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	private static final Logger log=LoggerFactory.getLogger(EmployeeController.class);
	
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		log.info("GET:/employees/-->Called");
		return employeeRepository.findAll();
	}
	

	// localhost:8080/api/v1/employees
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long emloyeeId)
			throws ResourceNotFoundException {
		log.info("GET:/employees/{"+emloyeeId+"}-->Called");
		Employee employee = employeeRepository.findById(emloyeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found  for id:" + emloyeeId));
		return ResponseEntity.ok().body(employee);
	
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
	
		employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
		log.info("POST:/employees/{"+employee.getId()+"}-->Called");
		return employeeRepository.save(employee);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long emloyeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
		log.info("PUT:/employees/{"+emloyeeId+"}-->Called");
		employeeRepository.findById(emloyeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found  for id:" + emloyeeId));
		
		//		Employee employee=employeeRepository.findById(emloyeeId)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not found  for id:" + emloyeeId));
//		employee.setEmailId(employeeDetails.getEmailId());
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		final Employee updateEmployee=employeeRepository.save(employee);
//		
		employeeDetails.setId(emloyeeId);
		final Employee updateEmployee=employeeRepository.save(employeeDetails);
		return ResponseEntity.ok(updateEmployee);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public Map<String ,Boolean> deleteEmployee(@PathVariable(value = "id") Long emloyeeId) throws ResourceNotFoundException{	
		log.info("DELETE:/employees/{"+emloyeeId+"}-->Called");
		Employee employee=employeeRepository.findById(emloyeeId)
		.orElseThrow(() -> new ResourceNotFoundException("Employee not found  for id:" + emloyeeId));

		employeeRepository.delete(employee);
		Map<String,Boolean> response=new HashMap<String, Boolean>();
		
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	
	

}
