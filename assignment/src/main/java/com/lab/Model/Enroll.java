package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    Semester semester;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "enroll_student", joinColumns = @JoinColumn(name = "enroll_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;
}
