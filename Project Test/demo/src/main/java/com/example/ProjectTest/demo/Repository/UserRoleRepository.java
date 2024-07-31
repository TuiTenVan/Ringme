package com.example.ProjectTest.demo.Repository;

import com.example.ProjectTest.demo.Entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    @Query("SELECT ur FROM UserRoleEntity ur WHERE ur.user.id = ?1")
    List<UserRoleEntity> findByUserId(Long userId);
}
