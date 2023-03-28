package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    @Column(nullable = false,unique = true,length = 45)
private String email;
    @Column(nullable=false,length = 2000)
private String password;
    @Column(length = 45,nullable = false,name = "first_name")
private String firstname;
    @Column(length = 45,nullable = false,name = "last_name")
private String lastname;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
    private List<Role> roles = new ArrayList<>();
}
