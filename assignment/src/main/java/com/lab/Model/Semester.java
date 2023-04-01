package com.lab.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "semesters")
@Data
public class Semester {
    @Id
    @Column(name = "semester_id",length = 4)
    private String id;
    @Column(name = "name",length = 10)
    private String name;
    @Column(name = "start_date")
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate start;
    @Column(name = "end_date")
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate end;
}
