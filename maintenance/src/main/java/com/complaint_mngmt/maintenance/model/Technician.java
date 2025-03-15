package com.complaint_mngmt.maintenance.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Entity
@Table(name = "technicians")
public class Technician {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String expertise;

    @OneToMany(mappedBy = "assignedTechnician", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> assignedComplaints = new ArrayList<>();

    // Constructors
    public Technician() {}

    public Technician(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
    }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setExpertise(String expertise) { this.expertise = expertise; }

    public void setAssignedComplaints(List<Complaint> assignedComplaints) { this.assignedComplaints = assignedComplaints; }
}
