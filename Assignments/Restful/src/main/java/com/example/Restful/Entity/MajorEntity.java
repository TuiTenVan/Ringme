package com.example.Restful.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="major")
@NoArgsConstructor
@AllArgsConstructor
public class MajorEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "majorname")
    private String name;

    @OneToMany(mappedBy = "major" ,fetch = FetchType.LAZY)
    private List<StudentEntity> studentEntities=new ArrayList<>();

}
