package com.example.Restful.Repository.Impl;

import com.example.Restful.Entity.ClassEntity;
import com.example.Restful.Repository.IClassRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClassRepository implements IClassRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ClassEntity findAllClassName(String classname) {
        String jpqlQuery = "SELECT c FROM ClassEntity c WHERE c.name = :classname";
        List<ClassEntity> resultList = entityManager
                .createQuery(jpqlQuery, ClassEntity.class)
                .setParameter("classname", classname)
                .getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public void addClass(ClassEntity classEntity) {
        entityManager.persist(classEntity);
    }

}
