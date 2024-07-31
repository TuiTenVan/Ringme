package com.exampleProject.Restaurant.Entity;

import javax.persistence.*;;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_salary")
public class SalaryEntity extends BaseEntity {
    @Column(name = "salary")
    private Integer salary;

    @Column(name = "month")
    private Integer month;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;
}
