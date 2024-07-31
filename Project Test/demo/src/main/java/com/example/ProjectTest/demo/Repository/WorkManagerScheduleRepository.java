package com.example.ProjectTest.demo.Repository;

import com.example.ProjectTest.demo.Entity.WorkManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkManagerScheduleRepository extends JpaRepository<WorkManagerEntity, Long> {
}
