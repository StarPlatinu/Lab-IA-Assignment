package com.lab.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "student_id", length = 20)
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

    @ManyToMany(mappedBy = "students")
    @EqualsAndHashCode.Exclude
    private List<Enroll> enrollList;
}
