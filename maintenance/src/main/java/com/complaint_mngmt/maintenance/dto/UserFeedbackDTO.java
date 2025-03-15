package com.complaint_mngmt.maintenance.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class UserFeedbackDTO {
    @Setter
    private Long id;
    private Long complaintId;
    private Long userId;
    private int rating;
    private String comments;
    @Setter
    private String email;

    public String getPassword() {
        return null;
    }
}