package com.example.Restful.Controller;

import com.example.Restful.DTO.StudentDTO;
import com.example.Restful.Service.IStudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    private static final Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private IStudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO studentDTO) {
        try {
            studentService.save(studentDTO);
            logger.info("Adding student");
            return ResponseEntity.ok(studentDTO);
        } catch (Exception e) {
            logger.error("Error occurred while adding student", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding student!");
        }
    }

    @DeleteMapping(value="/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        try {
            studentService.deleteStudent(id);
            logger.info("Deleting student with ID");
            return ResponseEntity.ok("Deleting student with ID");
        } catch (Exception e) {
            logger.error("Error occurred while deleting student with ID", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting student with ID");
        }
    }



    @GetMapping("/birthday")
    public List<StudentDTO> getStudentsWithBirthdayToday() {
        try {
            logger.info("Retrieving students with birthday today");
            List<StudentDTO> students = studentService.getStudentsWithBirthdayToday();
            if (students != null){
                return students;
            }
            return null;
        } catch (Exception e) {
            logger.error("Error occurred while retrieving students with birthday today", e);
            throw e;
        }
    }

    @GetMapping("/student/all")
    public ResponseEntity<?> getAllStudents(
            @RequestParam Map<String, String> search,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "2") Integer pageSize) {
        try {
            logger.info("Retrieving all students with search");
            return ResponseEntity.ok(studentService.getAllStudents(search, page, pageSize));
        } catch (Exception e) {
            logger.error("Error occurred while retrieving all students", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch students: " + e.getMessage());
        }
    }
}
