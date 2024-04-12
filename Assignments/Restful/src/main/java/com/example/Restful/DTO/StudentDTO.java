package com.example.Restful.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;

@Data
public class StudentDTO{
    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Birthday cannot be null")
    private LocalDate birthday;

    private String hometown;

    @Pattern(regexp = "^(male|female)$", message = "Gender must be either 'male' or 'female'")
    private String gender;

    @DecimalMin(value = "0.00", message = "Average must be at least 0.00")
    @DecimalMax(value = "10.00", message = "Average must not exceed 10.00")
    private String avg;

    @NotEmpty(message = "Class names cannot be empty")
    private List<String> className;

    @NotBlank(message = "Major name cannot be blank")
    private String majorName;

    @NotNull(message = "Major ID cannot be null")
    private Integer majorId;
}
