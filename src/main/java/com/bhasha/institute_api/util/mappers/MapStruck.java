package com.bhasha.institute_api.util.mappers;

import com.bhasha.institute_api.dto.CourseDTO;
import com.bhasha.institute_api.dto.StudentDTO;
import com.bhasha.institute_api.entity.Course;
import com.bhasha.institute_api.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStruck {
    Student stdDtoToEntity(StudentDTO studentDTO);
    StudentDTO stdEntityToDTO(Student student);
    Course courseDtoToEntity(CourseDTO courseDTO);
    CourseDTO courseEntityToDto(Course course);

    List<StudentDTO> stdEntityToDtoList(List<Student> students);
    List<CourseDTO> courseEntityToDtoList(List<Course> courses);
}
