package com.exampleProject.Restaurant.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_user")
public class UserEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserRoleEntity> userRoleEntityList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserRestaurantEntity> userRestaurantEntityList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<TimeSheetsEntity> timeSheetsEntityList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<WorkScheduleEntity> workScheduleEntityList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SalaryEntity> salaryEntityList;
}
