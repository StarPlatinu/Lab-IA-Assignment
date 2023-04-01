package com.lab.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "teachers")
public class Teacher {
    @Id
    @Column(name = "teacher_id",length = 20)
    private String teacherId;
    @Column
    private String name;
    @Column
    private String email;
    @Column(length = 11)
    private String phone;
    @Column
    private String address;
    @Column
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate birthdate;
    @Column(name = "pucture_url")
    private String pictureUrl;


}
