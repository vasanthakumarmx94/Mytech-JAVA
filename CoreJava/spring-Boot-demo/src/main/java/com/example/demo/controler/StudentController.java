package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	private final Logger loggerr=LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	StudentService studentService;
	
	
//	http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getStudents(){
		//loggerr.info("/Get Student Logger method:"+new java.util.Date().toString());
		return studentService.getStudent();
		
	}
// get student by id
//	http://localhost:8080/student/1
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable long id) {
		//loggerr.info("/Get Student BY ID method:"+new java.util.Date().toString());
		return studentService.getStudent(id);
		}
	
	// http://localhost:8080/student
		// ad json text to add             ---------------------------------
		@PostMapping("/student")
		public void addStudent(@RequestBody Student student) {
			//loggerr.info("/POST ADD Student Logger method:"+new java.util.Date().toString());
			studentService.addStudent(student);
		}
	
		
	//   http://localhost:8080/student/2
		
		@PutMapping("/student/{id}")
		public void deleteStudent(@PathVariable long id) {
			//loggerr.info("/DELETE Student BYID Logger method:"+new java.util.Date().toString());
			studentService.deleteStudent(id);
		}
		
		//  http://localhost:8080/students/4           ---------------------------------------
		@PutMapping("/students/{id}")
		public void updateStudent(@RequestBody Student student, long id) {
			//loggerr.info("/UPDATE Student Logger method:"+new java.util.Date().toString());
			student.setStid(id);
			studentService.updateStudent(student, id);
			
		}
		
	
		
		
		// ============== Repository Entity==============
		
		// http://localhost:8080/student/response
			// ad json text to add
			@PostMapping("/student/response")
			public ResponseEntity<Student> addStudentRresponse(@RequestBody Student student) {
				loggerr.error("/Add STUDENT RESPONSE student Logger method:"+new java.util.Date().toString());	
				studentService.addStudent(student);
				return new ResponseEntity<Student>(student,HttpStatus.CREATED);
			}
		
		
			//      http://localhost:8080/student/response/2
			@GetMapping("/student/response/{id}")
			public ResponseEntity<Object> getStudentResponse(@PathVariable long id) {
				Optional<Student> student = studentService.getStudent(id);
				if(student.isPresent())
					return new ResponseEntity<Object>(student,HttpStatus.OK);
				else {
					loggerr.error("/GET STUDENT BY ID student Logger method:"+new java.util.Date().toString());	
					return new ResponseEntity<Object>("No Such ID: "+id,HttpStatus.NOT_FOUND);
				}
			}
		
			
			// http://localhost:8080/students/response/2
			@PutMapping("/students/response/{id}")
			public ResponseEntity<Object> deleteStudentResponse(@PathVariable long id) {
				Optional<Student> student =studentService.getStudent(id);
				if(student.isPresent()) {
					studentService.deleteStudent(id);
					return new ResponseEntity<Object>(student,HttpStatus.OK);
				}
				else {
					loggerr.error("/Delete student LOGGER METHOD:"+new java.util.Date().toString());	
					return new ResponseEntity<Object>("No Such ID: "+id,HttpStatus.NOT_FOUND);
				}
			}
			
				
		//  http://localhost:8080/studentss/response/2           -----------------------
			@PutMapping("/studentss/response/{id}")
			public ResponseEntity<Object> updateStudentResponse(@RequestBody Student student, long id) {
				Optional<Student> student1 =studentService.getStudent(id);
				if(student1.isPresent()) {
					student.setStid(id);
					studentService.updateStudent(student, id);
					return new ResponseEntity<Object>(student1,HttpStatus.OK);
				}else {
					loggerr.error("/Update student Logger metod:"+new java.util.Date().toString());	
					return new ResponseEntity<Object>("No Such ID: "+id,HttpStatus.NOT_FOUND);
				}
			}
			
			
		//  http://localhost:8080/studentt/response/2     
			@PutMapping("/studentt/response/{id}")
			public ResponseEntity<Object> updateStudentResponse2(@RequestBody Student student,@PathVariable long id) {
				Optional<Student> student1 =studentService.getStudent(id);
				if(student1.isPresent()) {
					student.setStid(id);
					studentService.updateStudent(student, id);
					return new ResponseEntity<Object>(student1,HttpStatus.OK);
				}else
					return new ResponseEntity<Object>("No Such ID: "+id,HttpStatus.NOT_FOUND);
			
			}
			
			
			
		
	
		//  http://localhost:8080/allstudent
			@GetMapping("/allstudent")
			public List<Student> getallStudents(){
				return studentService.findAll();
			}
	
	
}
