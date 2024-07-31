package com.exampleProject.Restaurant.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_user_restaurant")
public class UserRestaurantEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    private RestaurantEntity restaurant;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;
}
