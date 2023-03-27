package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "grades")
@Data
public class Grade {
    @Id
    private int gradeId;

    @Column
    private int enroll_id;

    @OneToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;


}
