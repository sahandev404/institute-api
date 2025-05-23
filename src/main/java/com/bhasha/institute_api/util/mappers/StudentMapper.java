package com.bhasha.institute_api.util.mappers;

import com.bhasha.institute_api.dto.StudentDTO;
import com.bhasha.institute_api.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "id", ignore = true)
    Student DtoToEntity(StudentDTO studentDTO);
    StudentDTO EntityToDTO(Student student);
    List<StudentDTO> EntityListToDtoList(List<Student> students);
}