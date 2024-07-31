package com.example.ProjectTest.demo.Repository;

import com.example.ProjectTest.demo.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
