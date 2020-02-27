package com.course.registration.dao;

import com.course.registration.entity.Registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {
	
	//get score for a given student and course
	@Query(value = "select r.id,r.score,r.student_id,r.course_id from registration as r "
			+ "where r.student_id= :studentId and r.course_id= :courseId", nativeQuery = true)
	List<Registration> getScoreByStuAndCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);
}
