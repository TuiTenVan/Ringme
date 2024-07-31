package com.exampleProject.Restaurant.Entity;

import javax.persistence.*;
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
@Table(name = "tbl_work_manager")
public class WorkManagerEntity  extends BaseEntity{
    @Column(name = "time_start")
    private Date timeStart;

    @Column(name = "time_end")
    private Date timeEnd;

    @Column(name = "a_hour_salary")
    private Integer aHourSalary;

    @Column(name = "person_limit")
    private Integer personLimit;

    @Column(name = "percentage_bonus")
    private Integer percentageBonus;

    @Column(name = "deduction_percentage")
    private Integer deductionPercentage;

    @Column(name = "status")
    private Integer status;

//    @OneToMany(mappedBy = "workManager", fetch = FetchType.LAZY)
//    private List<WorkManagerEntity> workManagerEntityList;
}
