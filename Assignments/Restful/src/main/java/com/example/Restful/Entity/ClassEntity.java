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

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name="student_class",
//            joinColumns =@JoinColumn(name="class_id",nullable = false),
//            inverseJoinColumns = @JoinColumn(name="student_id",nullable = false))
//    private List<StudentEntity> students = new ArrayList<>();
    @OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY)
    private List<StudentClassEntity> studentClasses = new ArrayList<>();
}
