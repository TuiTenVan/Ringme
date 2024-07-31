package com.example.ProjectTest.demo.Entity;

import com.example.ProjectTest.demo.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_shift")
public class ShiftEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "time_in")
    private Date timeIn;

    @Column(name = "time_out")
    private Date timeOut;

    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "shift", fetch = FetchType.LAZY)
    private List<WorkScheduleEntity> workScheduleEntityList;
}
