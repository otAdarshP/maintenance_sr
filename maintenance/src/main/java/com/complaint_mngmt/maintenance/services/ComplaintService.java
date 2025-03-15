package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;
import java.util.List;

public interface ComplaintService {
    ComplaintDTO createComplaint(ComplaintDTO complaintDTO);
    ComplaintDTO getComplaintById(Long id);
    List<ComplaintDTO> getAllComplaintsByUser(Long userId);
}
