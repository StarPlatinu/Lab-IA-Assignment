package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "grades")
@Data
public class Grade {
    @Id
    @ManyToOne
    @JoinColumn(name = "enroll_id")
    private Enroll enroll;

    @Id
    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    @Column(name = "value")
    private int value;

    @Column(name = "comment")
    private String comment;
}
