package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;
import java.util.List;

public interface AdminService {
    List<ComplaintDTO> getAllComplaints();
    ComplaintDTO assignTechnician(Long complaintId, Long technicianId);
    ComplaintDTO rejectComplaint(Long complaintId);
}
