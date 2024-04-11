package com.example.Restful.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentDTO{
    private Integer id;
    private String name;
    private LocalDate birthday;
    private String hometown;
    private String gender;
    private String avg;
    private List<String> className;
    private String majorName;
    private Integer majorId;
}

