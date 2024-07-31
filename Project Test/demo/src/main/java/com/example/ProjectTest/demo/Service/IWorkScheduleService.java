package com.example.ProjectTest.demo.Service;

import com.example.ProjectTest.demo.DTO.WorkScheduleDTO;

import java.util.List;

public interface IWorkScheduleService {
    void createWorkSchedule(List<WorkScheduleDTO> workScheduleDTOs);
}
