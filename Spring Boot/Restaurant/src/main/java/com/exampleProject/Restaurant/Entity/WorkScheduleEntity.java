package com.exampleProject.Restaurant.Entity;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_work_schedule")
public class WorkScheduleEntity extends BaseEntity {
    @Column(name = "work_time")
    private Date workTime;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_shift")
    private ShiftEntity shift;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    private RestaurantEntity restaurant;

//    @ManyToOne
//    @JoinColumn(name = "id_work_manager")
//    private WorkManagerEntity workManager;
}
