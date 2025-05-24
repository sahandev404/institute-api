package com.bhasha.institute_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;
    @Past(message = "Birthday must be in past")
    private LocalDate birthday;
    private String address;
    @Size(min = 10, max = 10, message = "Contact number must be exactly 10 characters")
    private String contactNumber;
    private String department;
}
