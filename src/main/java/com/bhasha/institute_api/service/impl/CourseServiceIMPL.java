package com.bhasha.institute_api.service.impl;

import com.bhasha.institute_api.dto.CourseDTO;
import com.bhasha.institute_api.entity.Course;
import com.bhasha.institute_api.repository.CourseRepository;
import com.bhasha.institute_api.service.CourseService;
import com.bhasha.institute_api.util.mappers.CourseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public String addCourse(CourseDTO courseDTO) {
        try {
            if (courseRepository.existsById(courseDTO.getId())) {
                log.error("Course already exists with ID: {}", courseDTO.getId());
                return "Course already exists!";
            }else {
//                Course course = new Course();
//                course.setDepartment(courseDTO.getDepartment());
//                course.setCourseName(courseDTO.getCourseName());
//                course.setFees(courseDTO.getFees());
//                course.setMaxStudentCount(courseDTO.getMaxStudentCount());

                Course course = courseMapper.DtoToEntity(courseDTO);
                courseRepository.save(course);
                log.info("Course saved successfully: {}", course.getCourseName());
                return course.getCourseName() + " Course saved!";
            }
        } catch (Exception e) {
            log.error("Error saving course: {}", e.getMessage());
            return "Error: " + e.getMessage();
        }

    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            log.warn("No courses found");
            return List.of();
        }else {
            log.info("All courses retrieved successfully: {}", courses);
            return courseMapper.EntityListToDtoList(courses);
//            List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
//            for (Course course : courses) {
//                CourseDTO courseDTO = new CourseDTO();
//                courseDTO.setId(course.getId());
//                courseDTO.setDepartment(course.getDepartment());
//                courseDTO.setCourseName(course.getCourseName());
//                courseDTO.setFees(course.getFees());
//                courseDTO.setMaxStudentCount(course.getMaxStudentCount());
//                courseDTOList.add(courseDTO);
//            }
//            return courseDTOList;
        }
    }
}