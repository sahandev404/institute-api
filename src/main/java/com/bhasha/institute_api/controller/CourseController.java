package com.bhasha.institute_api.controller;

import com.bhasha.institute_api.dto.CourseDTO;
import com.bhasha.institute_api.service.CourseService;
import com.bhasha.institute_api.util.StandardResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<StandardResponse> addCourse(@Valid @RequestBody CourseDTO courseDTO) {
        String message = courseService.addCourse(courseDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message),
                HttpStatus.CREATED
        );

    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCourses() {
        List<CourseDTO> allCourses = courseService.getAllCourses();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",allCourses),
                HttpStatus.OK
        );
    }
}