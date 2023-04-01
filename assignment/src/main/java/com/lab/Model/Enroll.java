package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollId;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @OneToOne
    @JoinColumn(name = "course_id")
    Course course;

    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;

    @OneToOne
    @JoinColumn(name = "semester_id")
    Semester semester;
}
