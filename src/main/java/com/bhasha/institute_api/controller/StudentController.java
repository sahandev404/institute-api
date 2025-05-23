package com.bhasha.institute_api.controller;

import com.bhasha.institute_api.dto.StudentDTO;
import com.bhasha.institute_api.service.StudentService;
import com.bhasha.institute_api.util.StandardResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StandardResponse> addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        String message = studentService.addStudent(studentDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getStudentById(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",studentDTO),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllStudents() {
        List<StudentDTO> studentDTOs = studentService.getAllStudents();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",studentDTOs),
                HttpStatus.OK
        );
    }
}