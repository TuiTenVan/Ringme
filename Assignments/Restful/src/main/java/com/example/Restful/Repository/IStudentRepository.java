package com.example.Restful.Repository;

import com.example.Restful.Entity.StudentEntity;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IStudentRepository {
    void addStudent(StudentEntity student);

    void delete(StudentEntity student);

    //1 chỗ sử dụng mà ko cần trả về thì nên để void
    //Còn nếu có xử lý trường hợp có kết quả trả về thì mới dùng khác void
    //(Ví dụ không lưu được thì cần trả ra thông báo ko lưu được cho người dùng biết)
    void update(StudentEntity student);

    StudentEntity findById(Integer id);

    List<StudentEntity> findStudentsWithBirthday(LocalDate birthday);

    List<StudentEntity> findAllStudents(Map<String, String> search, Pageable pageable) ;
}
