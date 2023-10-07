package com.vasutech.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vasutech.Entity.Department;
import com.vasutech.Repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department savedepartment(Department department) {
		log.info("Inside service save department details ");
		return departmentRepository.save(department);
	}

	public Department findDepartmentByID(Long id) {
		
		return departmentRepository.findByDepartmentId(id);
	}

}
