package com.vasutech.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasutech.Entity.Department;
import com.vasutech.Service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping("/")
	public Department SaveDepartment(@RequestBody Department department) {
		log.info("save department details in controller");
		return departmentService.savedepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentByID(@PathVariable("id") Long deptid) {
		log.info("save department details in controller");
		return departmentService.findDepartmentByID(deptid);
	}
	
	
}
