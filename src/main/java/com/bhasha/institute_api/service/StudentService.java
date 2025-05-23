package com.bhasha.institute_api.service;

import com.bhasha.institute_api.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentDTO studentDTO, Long id);

    StudentDTO getStudentById(Long id);

    List<StudentDTO> getAllStudents();
}
