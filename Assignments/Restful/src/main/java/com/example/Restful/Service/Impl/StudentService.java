package com.example.Restful.Service.Impl;

import com.example.Restful.Converter.StudentConverter;
import com.example.Restful.DTO.StudentDTO;
import com.example.Restful.Entity.ClassEntity;
import com.example.Restful.Entity.StudentClassEntity;
import com.example.Restful.Entity.StudentEntity;
import com.example.Restful.Repository.IClassRepository;
import com.example.Restful.Repository.IStudentClassRepository;
import com.example.Restful.Repository.IStudentRepository;
import com.example.Restful.Service.IStudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private IClassRepository classRepository;
    @Autowired
    private IStudentClassRepository studentClassRepository;

    @Override
    //Đánh anotation này để thể hiện phương thức này được ghi đè từ 1 phương thức cha hoặc interface.
    //Annotation này cho phép kiểm tra xem phương thức mà bạn đang ghi đè có tồn tại trong lớp cha hay không.
    //Nếu không, trình biên dịch sẽ thông báo một lỗi và có thể dễ dàng sửa chữa lỗi này.
    //Annotation @Override cho phép ng khác đọc mã của dễ dàng hơn, họ sẽ hiểu rằng đó là một phương thức được ghi đè từ lớp cha hoặc interface.
    public void save(StudentDTO studentDTO) {
        try{
            StudentEntity studentEntity = studentConverter.toStudentEntity(studentDTO);
            if (studentDTO.getId() != null) {
                studentRepository.update(studentEntity);
            } else {
                studentRepository.addStudent(studentEntity);
            }
            List<String> classNames = studentDTO.getClassName();
            for (String className : classNames) {
                ClassEntity classEntity = classRepository.findAllClassName(className);
                if (classEntity == null) {
                    classEntity = new ClassEntity();
                    classEntity.setName(className);
                    classRepository.addClass(classEntity);
                }
                StudentClassEntity studentClass = new StudentClassEntity();
                studentClass.setStudent(studentEntity);
                studentClass.setClassEntity(classEntity);
                studentEntity.getStudentClasses().add(studentClass);
                classEntity.getStudentClasses().add(studentClass);
                studentClassRepository.add(studentClass);
            }
        } catch (Exception e){
            log.info("Exception: ", e);//dùng log4j để có thể xem log báo lỗi trên server
            System.out.println("Exception: " + e);//sout để xem log báo lỗi ở console
        }
    }

    @Override
    public void deleteStudent (Integer id) {
        try{
            if (id != null) {
                StudentEntity studentEntity = studentRepository.findById(id);
                //vì phương thức findById có case trả về null nên phải xử lý trường hợp nhận về là null
                //tránh trường hợp xóa giá trị null, dẫn đến lỗi
                if (studentEntity != null) {
                    studentRepository.delete(studentEntity);
                } else {
                    log.info("Không tồn tại ID: ", id);
                }
            }
            log.info("Giá trị ID: ", id);
        } catch (Exception e){
            log.info("Exception: ", e);
        }
    }

    @Override
    public List<StudentDTO> getStudentsWithBirthdayToday() {
        try{
            LocalDate today = LocalDate.now();
            List<StudentDTO> studentDTOList = new ArrayList<>();
            List<StudentEntity> studentEntityList = studentRepository.findStudentsWithBirthday(today);
            if (studentEntityList != null) {
                for(StudentEntity studentEntity : studentEntityList){
                    StudentDTO studentDTO = studentConverter.toStudentDTO(studentEntity);
                    studentDTOList.add(studentDTO);
                }
            }
            return studentDTOList;
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudents(Map<String, String> search, Integer page, Integer pageSize) {
        try{
            Pageable pageable = PageRequest.of(page - 1, pageSize);
            List<StudentEntity> studentEntityList = studentRepository.findAllStudents(search, pageable);
            List<StudentDTO> studentDTOList = new ArrayList<>();
            if (studentEntityList != null) {
                for (StudentEntity studentEntity : studentEntityList) {
                    StudentDTO studentDTO = studentConverter.toStudentDTO(studentEntity);
                    studentDTOList.add(studentDTO);
                }
            }
            return studentDTOList;
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
        return null;
    }
}
