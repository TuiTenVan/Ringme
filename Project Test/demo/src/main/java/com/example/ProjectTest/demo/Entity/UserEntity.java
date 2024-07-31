package com.example.ProjectTest.demo.Entity;

import com.example.ProjectTest.demo.Entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_user")
public class UserEntity extends BaseEntity implements UserDetails {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "gender")
    private String gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<UserRoleEntity> userRoleEntityList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserRestaurantEntity> userRestaurantEntityList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<TimeSheetsEntity> timeSheetsEntityList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<WorkScheduleEntity> workScheduleEntityList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SalaryEntity> salaryEntityList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // lay role
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<UserRoleEntity> userRoleEntityList = getUserRoleEntityList();
        for (UserRoleEntity userRoleEntity : userRoleEntityList) {
            String role = userRoleEntity.getRole().getName();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
