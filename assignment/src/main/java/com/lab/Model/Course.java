package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public  class Course {
    @Id
    @Column(name = "course_id",length = 20)
    private String courseId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;
    @Column(length = 2000)
    private String description;
    @Column
    private Integer credit;

}
