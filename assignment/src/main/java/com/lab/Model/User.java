package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    @Column(nullable = false,unique = true,length = 45)
private String email;
    @Column(length = 15)
private String password;
    @Column(length = 45,nullable = false,name = "first_name")
private String firstname;
    @Column(length = 45,nullable = false,name = "last_name")
private String lastname;
    private boolean enabled;
}
