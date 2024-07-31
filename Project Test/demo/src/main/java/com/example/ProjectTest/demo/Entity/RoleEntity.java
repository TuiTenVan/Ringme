package com.example.ProjectTest.demo.Entity;

import com.example.ProjectTest.demo.Entity.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "tbl_role")
public class RoleEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserRoleEntity> userRoleEntityList;

    public static String ADMIN = "ADMIN";
    public static String MANAGER = "MANAGER";
    public static String STAFF = "STAFF";
}
