package com.complaint_mngmt.maintenance.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    // Add other user fields as needed
}