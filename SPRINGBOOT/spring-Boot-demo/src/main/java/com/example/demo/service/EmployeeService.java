package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	// inject our EmpRepository

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getemployee() {

		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployee(long id) {
		return employeeRepository.findById(id);
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}

	public void updateEmployee(Employee employee, long id) {

		if (employeeRepository.findById(id).isPresent()) {
			employeeRepository.save(employee);

		}

	}

}
