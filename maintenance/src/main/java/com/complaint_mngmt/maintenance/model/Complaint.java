package com.complaint_mngmt.maintenance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "complaints")
public class Complaint {

    // Getters and Setters
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // User who raised the complaint

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IssueType issueType;

    @Setter
    @Column(nullable = false)
    private String description;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IssueStatus status;

    @Setter
    @ManyToOne
    @JoinColumn(name = "assigned_technician_id")
    private Technician assignedTechnician; // Assigned technician (nullable)

    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructors
    public Complaint() {}

    public Complaint(User user, IssueType issueType, String description, IssueStatus status, Technician assignedTechnician) {
        this.user = user;
        this.issueType = issueType;
        this.description = description;
        this.status = status;
        this.assignedTechnician = assignedTechnician;
        this.createdAt = LocalDateTime.now();
    }

}
