package com.neosoft.Task.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.Task.model.Stream;
import com.neosoft.Task.model.Student;
import com.neosoft.Task.repository.StreamRepository;
import com.neosoft.Task.repository.StudentRepository;

@Service(value ="streamService")
@Transactional
public class StreamServiceImpl  {

	
	@Autowired
    private StreamRepository streamRepository;

    @Autowired
    private StudentRepository studentRepository;
	
	//-------here methods--------------
	
    public int registerStudent1(StudentDTO StudentDTO) {
		studentRepository.save(StudentDTO);
	}
    
    
    @Override
    public Integer registerStudent(StudentDTO studentDTO) throws InfyInternException
    {
        Optional<Stream> opt = streamRepository.findById(studentDTO.getStreamDTO().getStramId());
        Stream stream = opt.orElseThrow(() -> new InfyInternException("Service.stream_NOT_FOUND"));
        
        Student studentNew = new Student();
        studentNew.setStream(stream);
       
        studentNew.setStudentId(studentDTO.getStudentId());
        studentNew.setName(studentDTO.getName());
        studentNew.setEmail(studentDTO.getEmail());
        //here ---set to allfileld of student
        
        Student newStudent = studentRepository.save(studentNew);
        return newStudent.getStudentId();
    }
    
    
    
    
	
	public void deleteStudent(Integer studentId) {
		
		Optional<Student> stud = studentRepository.findById(studentId);
        Student student = stud.orElseThrow(() -> new InfyInternException("Service.PROJECT_NOT_FOUND"));
        Stream stream = student.getStream();
        
        student.setStream(null);
        studentRepository.deleteById(studentId);
        
		
		
	}
	
	
	
}
