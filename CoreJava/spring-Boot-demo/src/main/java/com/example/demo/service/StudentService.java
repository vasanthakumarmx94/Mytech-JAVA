package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
@CacheConfig(cacheNames="students")
public class StudentService {

	// inject our EmpRepository
	@Autowired
	private StudentRepository studentRepository;
		
	
	public List<Student> getStudent(){
		return studentRepository.findAll();
	}
	public Optional<Student> getStudent(long id) {
		return studentRepository.findById(id);
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}

	public void updateStudent(Student student, long id) {
		if (studentRepository.findById(id).isPresent()) {
			studentRepository.save(student);

		}

	}

	
	// ============Testing spring boot cache=================
		@Cacheable    //  
		public List<Student> findAll() {
			slowService(); // waits 3 second before execute  find all
			return this.getStudent();
			
		}

		private void slowService() {
			try {
				Thread.sleep(3000L);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	
	
	
}

