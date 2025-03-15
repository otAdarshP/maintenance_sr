package com.complaint_mngmt.maintenance.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;
@Getter
@Entity
@Table(name = "users")
public class User {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaints = new ArrayList<>();
    // Constructors
    public User() {}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setId(Long id) { this.id = id; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

    public void setComplaints(List<Complaint> complaints) { this.complaints = complaints; }
    public String getEmail() {
        return null;
    }
    public void getClass(Class<?> aClass) {
    }

    public void setEmail(String email) {
    }

    public User getUser() {
        return null;
    }
}
