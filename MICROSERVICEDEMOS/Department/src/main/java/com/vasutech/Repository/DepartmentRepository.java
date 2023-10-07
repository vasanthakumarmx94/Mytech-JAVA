package com.vasutech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vasutech.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

	Department findByDepartmentId(Long id);
	
	
}
