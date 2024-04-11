package com.example.Restful.Repository;

import com.example.Restful.Entity.ClassEntity;

public interface IClassRepository {
    void addClass(ClassEntity classEntity);

    ClassEntity findAllClassName(String classname);
}
