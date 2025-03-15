package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;

public interface TechnicianService {
    ComplaintDTO resolveComplaint(Long complaintId);
}
