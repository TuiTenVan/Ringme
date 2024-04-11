package com.example.Restful.DTO;

import com.example.Restful.Entity.ClassEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentClassDTO {
    private Integer studentId;
    private List<ClassEntity> classEntityList;
}
