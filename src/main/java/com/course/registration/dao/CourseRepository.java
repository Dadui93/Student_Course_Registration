package com.course.registration.dao;

import com.course.registration.entity.Course;
import org.springframework.data.repository.CrudRepository;


public interface CourseRepository extends CrudRepository<Course, Long> {

}
