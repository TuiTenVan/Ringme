package com.example.ProjectTest.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_work_schedule")
public class WorkScheduleEntity extends BaseEntity {
    @Column(name = "work_time")
    private LocalDate workTime;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_shift")
    private ShiftEntity shift;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_work_manager")
    private WorkManagerEntity workManager;
}
