package com.example.ProjectTest.demo.Entity;

import com.example.ProjectTest.demo.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_timesheets")
public class TimeSheetsEntity extends BaseEntity {
    @Column(name = "time_in")
    private Date timeIn;

    @Column(name = "time_out")
    private Date timeOut;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;
}
