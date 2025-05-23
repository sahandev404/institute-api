package com.bhasha.institute_api.service.impl;

import com.bhasha.institute_api.dto.StudentDTO;
import com.bhasha.institute_api.entity.Student;
import com.bhasha.institute_api.repository.StudentRepository;
import com.bhasha.institute_api.service.StudentService;
import com.bhasha.institute_api.util.mappers.MapStruck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private MapStruck mapStruck;

    @Override
    public String addStudent(StudentDTO studentDTO) {
        try {
//            Student student = mapStruck.stdDtoToEntity(studentDTO);
            Student student = new Student();
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setBirthday(studentDTO.getBirthday());
            student.setAddress(studentDTO.getAddress());
            student.setContactNumber(studentDTO.getContactNumber());
            student.setDepartment(studentDTO.getDepartment());
            student.setCourse(studentDTO.getCourse());
            studentRepository.save(student);
            log.info("Student saved: {}", student);
            return studentDTO.getFirstName() + " Student saved!";
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
//            StudentDTO studentDTO = mapStruck.stdEntityToDTO(student);
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setFirstName(student.getFirstName());
            studentDTO.setLastName(student.getLastName());
            studentDTO.setBirthday(student.getBirthday());
            studentDTO.setAddress(student.getAddress());
            studentDTO.setContactNumber(student.getContactNumber());
            studentDTO.setDepartment(student.getDepartment());
            studentDTO.setCourse(student.getCourse());
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
//            List<StudentDTO> studentDTOs = mapStruck.stdEntityToDtoList(students);
            List<StudentDTO> studentDTOs = new ArrayList<>();
            for (Student student : students) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setFirstName(student.getFirstName());
                studentDTO.setLastName(student.getLastName());
                studentDTO.setBirthday(student.getBirthday());
                studentDTO.setAddress(student.getAddress());
                studentDTO.setContactNumber(student.getContactNumber());
                studentDTO.setDepartment(student.getDepartment());
                studentDTO.setCourse(student.getCourse());
                studentDTOs.add(studentDTO);
            }
            return studentDTOs;
        } catch (Exception e) {
            log.error("Error retrieving all students: {}", e.getMessage());
            return null;
        }
    }
}