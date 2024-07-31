package com.example.ProjectTest.demo.Repository;

import com.example.ProjectTest.demo.Entity.ShiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<ShiftEntity, Long> {
}
