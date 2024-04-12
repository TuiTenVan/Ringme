package com.example.Restful.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="class")
@NoArgsConstructor
@AllArgsConstructor
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "classname")
    private String name;

    @OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY)
    private List<StudentClassEntity> studentClasses = new ArrayList<>();
}
