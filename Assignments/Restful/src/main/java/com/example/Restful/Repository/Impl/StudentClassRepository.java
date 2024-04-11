package com.example.Restful.Repository.Impl;

import com.example.Restful.Entity.StudentClassEntity;
import com.example.Restful.Repository.IStudentClassRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentClassRepository implements IStudentClassRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(StudentClassEntity student) {
        entityManager.persist(student);
    }

}
