package com.bhasha.institute_api.service;

import com.bhasha.institute_api.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    String addCourse(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();
}
