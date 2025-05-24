package com.bhasha.institute_api.util.mappers;

import com.bhasha.institute_api.dto.CourseDTO;
import com.bhasha.institute_api.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "id", ignore = true)
    Course DtoToEntity(CourseDTO courseDTO);
    CourseDTO EntityToDto(Course course);
    List<CourseDTO> EntityListToDtoList(List<Course> courses);
}