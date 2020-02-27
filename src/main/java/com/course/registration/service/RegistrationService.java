package com.course.registration.service;

import java.util.List;

import com.course.registration.entity.Student;

public interface RegistrationService {
	
	void addStudentWithCourses(String name, List<Long> courseIds);
	
	void deleteStudent(long stuId);
	
	List<Student> getStudentsByCourse(String courseName);
	
	int getScoreByStuAndCourse(Long stuId, Long courseId);
	
	List<Student> getNotRegisteredStuByCourse(String courseName);
}
