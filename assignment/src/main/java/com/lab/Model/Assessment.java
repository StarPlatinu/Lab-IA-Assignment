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

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "assessment_category_id")
    private AssessmentCategory assessmentCategory;

    @Column
    private String assessmentName;

    @Column
    private int weight;
}
