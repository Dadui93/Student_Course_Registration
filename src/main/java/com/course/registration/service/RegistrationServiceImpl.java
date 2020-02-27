package com.course.registration.service;

import com.course.registration.dao.RegistrationRepository;
import com.course.registration.dao.StudentRepository;
import com.course.registration.entity.Registration;
import com.course.registration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private StudentRepository studentRepository;

    //add a new student along with their course registrations
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addStudentWithCourses(String name, List<Long> courseIds) {
        Student student = new Student();
        student.setStudentName(name);
        student = studentRepository.save(student);

        List<Registration> registrations = new ArrayList<>();
        for (Long courseId : courseIds) {
            Registration registration = new Registration();
            registration.setCourseId(courseId);
            registration.setStudentId(student.getId());
            registrations.add(registration);
        }
        registrationRepository.saveAll(registrations);
    }

	//Delete a student
    @Override
    public void deleteStudent(long stuId) {
        if (studentRepository.findById(stuId).isPresent()) {
            studentRepository.deleteById(stuId);
        }
    }

	//Get all students, sorted by their name, for a given course with course name as input
    @Override
    public List<Student> getStudentsByCourse(String courseName) {
        return studentRepository.getStudentsByCourse(courseName);
    }

	//get score for a given student and course
    @Override
    public int getScoreByStuAndCourse(Long stuId, Long courseId) {
        List<Registration> scoreByStuAndCourse = registrationRepository.getScoreByStuAndCourse(stuId, courseId);
        if (CollectionUtils.isEmpty(scoreByStuAndCourse)) {
            return 0;
        }
        return scoreByStuAndCourse.get(0).getScore();
    }

	//get all students who don’t register for a given course
    @Override
    public List<Student> getNotRegisteredStuByCourse(String courseName) {
        return studentRepository.getNotRegisteredStuByCourse(courseName);
    }

}
