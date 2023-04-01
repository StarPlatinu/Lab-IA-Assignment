package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id", length = 20)
    private String id;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "credit")
    private int credit;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;
}
