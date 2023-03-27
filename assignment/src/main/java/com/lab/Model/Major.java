package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "majors")
public class Major {
    @Id
    @Column(name = "major_id",length = 2)
private String majorId;
    @Column
private String majorName;
}
