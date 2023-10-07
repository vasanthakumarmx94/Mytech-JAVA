package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
