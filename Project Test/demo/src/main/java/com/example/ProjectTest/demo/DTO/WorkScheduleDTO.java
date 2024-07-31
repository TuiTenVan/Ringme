package com.example.ProjectTest.demo.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkScheduleDTO extends AbstractDTO {
    private LocalDate workTime;
    private Long shiftId;
    private Long userId;
    private Long workManagerId;
//    private Integer status;
}
