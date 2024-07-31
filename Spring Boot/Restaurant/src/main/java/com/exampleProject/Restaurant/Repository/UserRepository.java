package com.exampleProject.Restaurant.Repository;

import com.exampleProject.Restaurant.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String username);
    UserEntity findByPhone(String phone);

}
