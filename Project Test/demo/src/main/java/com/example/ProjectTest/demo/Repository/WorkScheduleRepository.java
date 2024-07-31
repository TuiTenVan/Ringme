package com.example.ProjectTest.demo.Repository;

import com.example.ProjectTest.demo.Entity.WorkScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkScheduleRepository extends JpaRepository<WorkScheduleEntity, Long> {
}
