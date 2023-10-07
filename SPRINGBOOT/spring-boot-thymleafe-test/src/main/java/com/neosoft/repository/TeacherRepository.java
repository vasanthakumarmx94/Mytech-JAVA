package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
