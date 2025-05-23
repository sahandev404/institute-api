package com.bhasha.institute_api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private Long id;
    @NotBlank(message = "Department cannot be blank")
    private String department;
    @NotBlank(message = "Course name cannot be blank")
    private String courseName;
    @Positive(message = "Fees must be positive value")
    private Double fees;
    @Positive(message = "Max student count must be positive value")
    private Integer maxStudentCount;
}
