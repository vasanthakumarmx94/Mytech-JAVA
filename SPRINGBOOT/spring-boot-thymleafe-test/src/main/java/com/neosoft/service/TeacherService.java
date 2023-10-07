package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Teacher;

public interface TeacherService {
	List<Teacher> getAllTeachers();

	Teacher saveTeacher(Teacher teacher);

	Teacher getTeacherById(Long Tid);

	Teacher updateTeacher(Teacher teacher);

	void deleteTeacherById(Long Tid);
	
}
