package com.bhasha.institute_api.repository;

import com.bhasha.institute_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
