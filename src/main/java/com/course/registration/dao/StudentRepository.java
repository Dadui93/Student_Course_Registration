package com.course.registration.dao;

import com.course.registration.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends CrudRepository<Student, Long> {

	//get all students who don’t register for a given course
	@Query(value = "select s.id, s.student_name from student s  where s.id not in "
			+ "(select r.student_id from registration as r inner join course as c on r.course_id = c.id where c.course_name= :courseName ) "
			+ "order by s.student_name", nativeQuery = true)
	List<Student> getNotRegisteredStuByCourse(@Param("courseName") String courseName);

	//Get all students, sorted by their name, for a given course with course name as input
	@Query(value = "select s.id, s.student_name from student s " + "inner join registration r on s.id=r.student_id "
			+ "inner join  course c on r.course_id=c.id "
			+ "where c.course_name= :courseName  order by s.student_name", nativeQuery = true)
	List<Student> getStudentsByCourse(@Param("courseName") String courseName);
}
