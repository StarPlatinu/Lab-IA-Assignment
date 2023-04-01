package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "assessments")
public class Assessment {
    @Id
    @Column(name = "asessment_id")
    private int assessmentId;
    @Column
    private String assessmentName;

    @ManyToOne
    @JoinColumn(name = "course_id")
     Course course;
    @Column
    private int weight;

}
