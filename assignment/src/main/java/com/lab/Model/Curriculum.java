package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "curriculums")
public class Curriculum {
    @Id
    @Column(name = "curriculum_id",length = 20)
private String curriculumId;

    @OneToOne
    @JoinColumn(name = "major_id")
private Major major;
    @Column
private String name;

}
