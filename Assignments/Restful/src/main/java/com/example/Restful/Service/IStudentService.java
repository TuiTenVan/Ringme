package com.example.Restful.Service;

import com.example.Restful.DTO.StudentDTO;
import com.example.Restful.Entity.StudentEntity;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    StudentEntity save(StudentDTO studentDTO);
    void deleteStudent (Integer id);
    List<StudentDTO> getStudentsWithBirthdayToday();
    List<StudentDTO> getAllStudents(Map<String, String> search, Integer page, Integer pageSize);
}
