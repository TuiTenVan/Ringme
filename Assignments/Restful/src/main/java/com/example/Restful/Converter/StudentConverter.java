package com.example.Restful.Converter;

import com.example.Restful.DTO.StudentDTO;
import com.example.Restful.Entity.StudentClassEntity;
import com.example.Restful.Entity.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentConverter{
    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO toStudentDTO(StudentEntity item) {
        StudentDTO studentDTO = modelMapper.map(item, StudentDTO.class);
        List<StudentClassEntity> studentClassEntities = item.getStudentClasses();
        List<String> classList = new ArrayList<>();
        for (StudentClassEntity studentClassEntity : studentClassEntities) {
            String className = studentClassEntity.getClassEntity().getName();
            classList.add(className);
        }
        studentDTO.setClassName(classList);
        if (item.getMajor() != null) {
            studentDTO.setMajorName(item.getMajor().getName());
        }
        return studentDTO;
    }


    public StudentEntity toStudentEntity(StudentDTO item) {
        StudentEntity studentEntity = modelMapper.map(item, StudentEntity.class);
        return studentEntity;
    }
}
