package com.complaint_mngmt.maintenance.dto;

import com.complaint_mngmt.maintenance.model.IssueStatus;
import com.complaint_mngmt.maintenance.model.IssueType;
import lombok.Data;

@Data
public class ComplaintDTO {
    private Long id;
    private Long userId;              // ID of the user who filed the complaint
    private IssueType issueType;
    private String description;
    private IssueStatus status;
    private Long assignedTechnicianId; // ID of assigned technician
}
