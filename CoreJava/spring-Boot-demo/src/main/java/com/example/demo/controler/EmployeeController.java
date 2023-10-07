package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EmployeeService employeeService;
	
//	http://localhost:8080/employee
	@GetMapping("/employee")
	public List<Employee> getUser(){
		logger.info("/Get Employee Logger method:"+new java.util.Date().toString());
		return employeeService.getemployee();
		
	}
	
//	http://localhost:8080/employees/103
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable long id) {
		return employeeService.getEmployee(id);
		}
	
	
	// http://localhost:8080/employee
	// ad json text to add
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	//   http://localhost:8080/employees/2
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}
	
	//  http://localhost:8080/employeess/2
	@PutMapping("/employeess/{id}")
	public void updateEmployee(@RequestBody Employee employee, long id) {
		
		employee.setId(id);
		employeeService.updateEmployee(employee, id);
		
	}
	
	// ============== Response Entity==============
	
	// http://localhost:8080/employee/response
		// ad json text to add
		@PostMapping("/employee/response")
		public ResponseEntity<Employee> addEmployeRresponse(@RequestBody Employee employee) {
			employeeService.addEmployee(employee);
			return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		}
	
	
		//      http://localhost:8080/employees/response/2
		@GetMapping("/employees/response/{id}")
		public ResponseEntity<Object> getEmployeeResponse(@PathVariable long id) {
			Optional<Employee> employee = employeeService.getEmployee(id);
			if(employee.isPresent())
				return new ResponseEntity<Object>(employee,HttpStatus.OK);
			else
				return new ResponseEntity<Object>("No Such ID: "+id,HttpStatus.NOT_FOUND);
		}
	

		
		// http://localhost:8080/customHeader
		@GetMapping("/customHeader")
		ResponseEntity<String> customHeader(){
			return ResponseEntity.ok()
					.header("Customer-header", "NeoSoft")
					.body("Costom header set");
		}
		
		// http://localhost:8080/employees/response/2
		@PutMapping("/employees/response/{id}")
		public ResponseEntity<Object> deleteEmployeeResponse(@PathVariable long id) {
			Optional<Employee> employee =employeeService.getEmployee(id);
			if(employee.isPresent()) {
				employeeService.deleteEmployee(id);
				return new ResponseEntity<Object>(employee,HttpStatus.OK);
			}
			else {
				logger.error("/Delete EMPLOYEE LOGGER METHOD:"+new java.util.Date().toString());	
				return new ResponseEntity<Object>("No Such ID: "+id,HttpStatus.NOT_FOUND);
			}
		}
		
		
		
	//  http://localhost:8080/employeess/response2
		@PutMapping("/employeess/response/{id}")
		public ResponseEntity<Object> updateEmployeeResponse(@RequestBody Employee employee, long id) {
			Optional<Employee> employee1 =employeeService.getEmployee(id);
			if(employee1.isPresent()) {
				employee.setId(id);
				employeeService.updateEmployee(employee, id);
				return new ResponseEntity<Object>(employee1,HttpStatus.OK);
			}else
				return new ResponseEntity<Object>("No Such ID: "+id,HttpStatus.NOT_FOUND);
		
		}
		
		
		// add some long info ,warn,err
		// http://localhost:8080/logger
		
		@GetMapping("/logger")
		public String getLogger() {
			logger.info("/logger Method:"+new java.util.Date().toString());
			logger.warn("/logger Method:"+new java.util.Date().toString());
			logger.error("/logger Method:"+new java.util.Date().toString());	
			return "Logger test";
		}
		
		
		
		
		
	
}
