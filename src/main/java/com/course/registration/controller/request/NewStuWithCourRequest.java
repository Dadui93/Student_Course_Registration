package com.course.registration.controller.request;

import java.util.List;


public class NewStuWithCourRequest {
    private List<Long> courseIds;
    private String name;

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
