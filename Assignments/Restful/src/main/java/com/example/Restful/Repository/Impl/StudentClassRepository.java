package com.example.Restful.Repository.Impl;

import com.example.Restful.Entity.StudentClassEntity;
import com.example.Restful.Repository.IStudentClassRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Log4j2
public class StudentClassRepository implements IStudentClassRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(StudentClassEntity student) {
        try{
            entityManager.persist(student);
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
    }
}
