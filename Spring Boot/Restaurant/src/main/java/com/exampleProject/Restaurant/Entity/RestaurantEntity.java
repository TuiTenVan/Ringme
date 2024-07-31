package com.exampleProject.Restaurant.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_restaurant")
public class RestaurantEntity extends BaseEntity {

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private List<UserRestaurantEntity> userRestaurantEntityList;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private List<WorkScheduleEntity> workScheduleEntityList;
}
