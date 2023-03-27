package com.lab.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "semessters")
@Data
public class Semester {
    @Id
    @Column(name = "semester_id",length = 10)
    private String semesterId;
    @Column(name = "start_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate start;
    @Column(name = "end_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private   LocalDate end;
}
