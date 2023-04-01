package com.lab.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "majors")
public class Major {
    @Id
    @Column(name = "major_id", length = 2)
    private String id;

    @Column
    private String name;
}
