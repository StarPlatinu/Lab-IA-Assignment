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
    @Column(name = "teacher_id", length = 20)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone", length = 11)
    private String phone;
    @Column(name = "address")
    private String address;

    @Column(name = "birthdate")
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate birthdate;

    @Column(name = "picture_url")
    private String pictureUrl;
}
