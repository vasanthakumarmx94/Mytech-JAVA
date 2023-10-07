package com.example.demo.controler;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	EmployeeService employeeService;
	
//	http://localhost:8080/employee
	@GetMapping("/employee")
	public List<Employee> getUser(){
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
	
	@PutMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}
	
	//  http://localhost:8080/employeess/2
	@PutMapping("/employeess/{id}")
	public void updateEmployee(@RequestBody Employee employee, long id) {
		
		employee.setId(id);
		employeeService.updateEmployee(employee, id);
		
	}
	
	
	
	
	
}
