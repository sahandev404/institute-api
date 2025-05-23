package com.bhasha.institute_api.repository;

import com.bhasha.institute_api.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
