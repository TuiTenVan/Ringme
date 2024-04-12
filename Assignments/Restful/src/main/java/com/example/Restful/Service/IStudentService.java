package com.example.Restful.Service;

import com.example.Restful.DTO.StudentDTO;
import com.example.Restful.Entity.StudentEntity;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    void save(StudentDTO studentDTO);//Vì chỉ có 1 chô sử dụng phương thức này và nó ko cần trả về, nên để là void

    void deleteStudent (Integer id);

    List<StudentDTO> getStudentsWithBirthdayToday();

    List<StudentDTO> getAllStudents(Map<String, String> search, Integer page, Integer pageSize);
}
