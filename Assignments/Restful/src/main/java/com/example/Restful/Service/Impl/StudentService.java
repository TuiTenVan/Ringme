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
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private IClassRepository classRepository;
    @Autowired
    private IStudentClassRepository studentClassRepository;

    public StudentEntity save(StudentDTO studentDTO) {
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
        return studentEntity;
    }

    public void deleteStudent (Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id);
        studentRepository.delete(studentEntity);
    }

    public List<StudentDTO> getStudentsWithBirthdayToday() {
        LocalDate today = LocalDate.now();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        List<StudentEntity> studentEntityList = studentRepository.findStudentsWithBirthday(today);
        for(StudentEntity studentEntity : studentEntityList){
            StudentDTO studentDTO = studentConverter.toStudentDTO(studentEntity);
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    public List<StudentDTO> getAllStudents(Map<String, String> search, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        List<StudentEntity> studentEntityList = studentRepository.findAllStudents(search, pageable);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntityList) {
            StudentDTO studentDTO = studentConverter.toStudentDTO(studentEntity);
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

}
