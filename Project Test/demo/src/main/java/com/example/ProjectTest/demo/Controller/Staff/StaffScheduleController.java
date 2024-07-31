package com.example.ProjectTest.demo.Controller.Staff;

import com.example.ProjectTest.demo.DTO.WorkScheduleDTO;
import com.example.ProjectTest.demo.Service.IWorkScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffScheduleController {
    private final IWorkScheduleService workScheduleService;

    @PostMapping("/schedule")
    public ResponseEntity<?> createSchedule(@Valid @RequestBody List<WorkScheduleDTO> workScheduleDTOs,
                                            BindingResult result){
        try{
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            workScheduleService.createWorkSchedule(workScheduleDTOs);
            return ResponseEntity.ok("Register Schedule successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
