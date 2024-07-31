package com.example.ProjectTest.demo.Service.Impl;


import com.example.ProjectTest.demo.DTO.WorkScheduleDTO;
import com.example.ProjectTest.demo.Entity.ShiftEntity;
import com.example.ProjectTest.demo.Entity.UserEntity;
import com.example.ProjectTest.demo.Entity.WorkManagerEntity;
import com.example.ProjectTest.demo.Entity.WorkScheduleEntity;
import com.example.ProjectTest.demo.Repository.ShiftRepository;
import com.example.ProjectTest.demo.Repository.UserRepository;
import com.example.ProjectTest.demo.Repository.WorkManagerScheduleRepository;
import com.example.ProjectTest.demo.Repository.WorkScheduleRepository;
import com.example.ProjectTest.demo.Service.IWorkScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService implements IWorkScheduleService {
    private final WorkScheduleRepository workScheduleRepository;
    private final ShiftRepository shiftRepository;
    private final UserRepository userRepository;
    private final WorkManagerScheduleRepository workManagerScheduleRepository;

    @Override
    public void createWorkSchedule(List<WorkScheduleDTO> workScheduleDTOs) {
        for (WorkScheduleDTO workScheduleDTO : workScheduleDTOs) {
            WorkScheduleEntity workSchedule = new WorkScheduleEntity();
            workSchedule.setWorkTime(workScheduleDTO.getWorkTime());
            ShiftEntity shiftEntity = shiftRepository.findById(workScheduleDTO.getShiftId()).orElseThrow(
                    () -> new RuntimeException("Shift not found")
            );
            workSchedule.setShift(shiftEntity);
            UserEntity userEntity = userRepository.findById(workScheduleDTO.getUserId()).orElseThrow(
                    () -> new RuntimeException("User not found")
            );
            workSchedule.setUser(userEntity);
            WorkManagerEntity workManager = workManagerScheduleRepository.findById(workScheduleDTO.getWorkManagerId()).orElseThrow(
                    () -> new RuntimeException("Work manager not found")
            );
            workSchedule.setWorkManager(workManager);
            workScheduleRepository.save(workSchedule);
        }
    }
}
