package com.bhasha.institute_api.service.impl;

import com.bhasha.institute_api.dto.StudentDTO;
import com.bhasha.institute_api.entity.Course;
import com.bhasha.institute_api.entity.Student;
import com.bhasha.institute_api.repository.CourseRepository;
import com.bhasha.institute_api.repository.StudentRepository;
import com.bhasha.institute_api.service.StudentService;
import com.bhasha.institute_api.util.mappers.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String addStudent(StudentDTO studentDTO, Long courseId) {
        try {
                Course course = courseRepository.findById(courseId).orElse(null);
                if (course == null) {
                    log.error("Course not found with ID: {}", courseId);
                    return "Course not found!";
                }else {
                    Student student = studentMapper.DtoToEntity(studentDTO);
                    student.setCourse(course);
                    studentRepository.save(student);
                    log.info("Student saved: {}", student);
                    return studentDTO.getFirstName() + " Student saved!";
                }
        } catch (Exception e) {
            log.error("Error saving student: {}", e.getMessage());
            return "Error saving student: " + e.getMessage();
        }
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        try {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            log.info("Student found: {}", student);
            StudentDTO studentDTO = studentMapper.EntityToDTO(student);
            log.info("Student DTO created: {}", studentDTO);
            return studentDTO;
        } catch (Exception e) {
            log.error("Error finding student: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        try{
            List<Student> students = studentRepository.findAll();
            log.info("All students retrieved: {}", students);
            List<StudentDTO> studentDTOs = studentMapper.EntityListToDtoList(students);
//            }
            return studentDTOs;
        } catch (Exception e) {
            log.error("Error retrieving all students: {}", e.getMessage());
            return null;
        }
    }
}