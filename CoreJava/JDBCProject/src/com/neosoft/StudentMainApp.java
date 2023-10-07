package com.neosoft;

import com.neosoft.controller.StudentController;

public class StudentMainApp {

	public static void main(String[] args) {

		// Get student name and markss

		StudentController.getAllStudents().stream()
				.forEach(student -> System.out.println(student.getStname() + ":" + student.getMarks()));
		System.out.println("-------------------------");

		// get students where marks >92
		StudentController.getAllStudents().stream().filter(std -> std.getMarks() > 92)
				.forEach(el -> System.out.println(el.getStname() + ": " + el.getMarks()));

	}

}

