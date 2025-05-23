package com.bhasha.institute_api.dto;

import com.bhasha.institute_api.entity.Course;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Long id;
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;
    @Past(message = "Birthday must be in past")
    private LocalDate birthday;
    private String address;
    @Max(value = 10, message = "Contact number must be less than 10 digits")
    private String contactNumber;
    private String department;
}
