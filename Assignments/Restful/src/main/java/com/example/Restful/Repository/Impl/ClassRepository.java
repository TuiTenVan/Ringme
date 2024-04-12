package com.example.Restful.Repository.Impl;

import com.example.Restful.Entity.ClassEntity;
import com.example.Restful.Repository.IClassRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Log4j2
public class ClassRepository implements IClassRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ClassEntity findAllClassName(String classname) {
        try {
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
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
        return null;
    }

    @Override
    public void addClass(ClassEntity classEntity) {
        try{
            entityManager.persist(classEntity);
        }catch (Exception e) {
            log.info("Exception: " , e);
        }
    }
}
