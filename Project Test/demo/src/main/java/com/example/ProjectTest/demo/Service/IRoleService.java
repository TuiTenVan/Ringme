package com.example.ProjectTest.demo.Service;

import com.example.ProjectTest.demo.Entity.RoleEntity;
import com.example.ProjectTest.demo.Entity.UserEntity;

import java.util.Map;

public interface IRoleService {
    Map<String, Object> getStringObjectMap(UserEntity existingUser, String token);
    RoleEntity findById(Long id);
}
