package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "assessment_categories")
public class AssessmentCategory {
    @Id
    @Column(name = "assesment_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
}
