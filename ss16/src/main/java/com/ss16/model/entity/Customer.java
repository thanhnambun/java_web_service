package com.ss16.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String fullName;
    private String password;
    private String email;
    private String phone;
    private Boolean isLogin = false;
    private Boolean status = true;
}
