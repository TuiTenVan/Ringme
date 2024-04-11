package com.example.Restful.Repository;

import com.example.Restful.Entity.StudentEntity;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IStudentRepository {
    void addStudent(StudentEntity student);
    void delete(StudentEntity student);
    StudentEntity update(StudentEntity student);
    StudentEntity findById(Integer id);
    List<StudentEntity> findStudentsWithBirthday(LocalDate birthday);
    List<StudentEntity> findAllStudents(Map<String, String> search, Pageable pageable) ;
}
