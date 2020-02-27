package com.course.registration.controller;

import com.course.registration.controller.response.APIResponse;
import com.course.registration.controller.request.NewStuWithCourRequest;
import com.course.registration.entity.Student;
import com.course.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reqistration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    //add a new student along with their course registrations
    @PostMapping("/addNewStuWithCourse")
    public APIResponse<String> addNewStuWithCour(@RequestBody NewStuWithCourRequest request) {
        registrationService.addStudentWithCourses(request.getName(), request.getCourseIds());
        return APIResponse.ofSuccess();
    }

    //Delete a student
    @DeleteMapping("/deleteStudent")
    public APIResponse<String> deleteStuById(@RequestParam(name = "stuId") Long stuId) {
        registrationService.deleteStudent(stuId);
        return APIResponse.ofSuccess();
    }

    //get score for a given student and course
    @GetMapping("/getScoreByStuCourse")
    public APIResponse<Integer> getScoreByStuCourse(@RequestParam(name = "stuId") Long stuId, @RequestParam(name = "courseId") Long courseId) {
        return APIResponse.ofSuccess(registrationService.getScoreByStuAndCourse(stuId, courseId));
    }

    //Get all students, sorted by their name, for a given course with course name as input
    @GetMapping("/getStuByCourse")
    public APIResponse<List<Student>> getStuByCourse(@RequestParam(name = "courseName") String courseName) {
        return APIResponse.ofSuccess(registrationService.getStudentsByCourse(courseName));
    }

    //get all students who don’t register for a given course
    @GetMapping("/getStuNotRegisteredByCourse")
    public APIResponse<List<Student>> getStuNotRegisteredByCourse(@RequestParam(name = "courseName") String courseName) {
        return APIResponse.ofSuccess(registrationService.getNotRegisteredStuByCourse(courseName));
    }
}
