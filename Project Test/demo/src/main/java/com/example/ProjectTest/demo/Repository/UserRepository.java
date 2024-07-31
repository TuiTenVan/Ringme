package com.example.ProjectTest.demo.Repository;

import com.example.ProjectTest.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByPhone(String phone);
    boolean existsByPhone(String phoneNumber);
    List<UserEntity> findByStatus(Integer status);
    @Query("SELECT u FROM UserEntity u WHERE u.status >= :status")
    List<UserEntity> findAll(@RequestParam("status") int status);
    @Query("SELECT u FROM UserEntity u WHERE u.fullName = :fullName")
    List<UserEntity> findAllByFullName(@RequestParam("fullName") String fullName);

}
