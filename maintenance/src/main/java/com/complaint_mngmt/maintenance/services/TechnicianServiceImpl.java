package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;
import com.complaint_mngmt.maintenance.exception.ResourceNotFoundException;
import com.complaint_mngmt.maintenance.model.Complaint;
import com.complaint_mngmt.maintenance.model.IssueStatus;
import com.complaint_mngmt.maintenance.repository.ComplaintRepository;
import com.complaint_mngmt.maintenance.services.TechnicianService;
import org.springframework.stereotype.Service;

@Service
public class TechnicianServiceImpl implements TechnicianService {

    private final ComplaintRepository complaintRepository;

    public TechnicianServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public ComplaintDTO resolveComplaint(Long complaintId) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
        complaint.setStatus(IssueStatus.RESOLVED);
        complaintRepository.save(complaint);
        return mapToDTO(complaint);
    }

    private ComplaintDTO mapToDTO(Complaint complaint) {
        ComplaintDTO dto = new ComplaintDTO();
        dto.setId(complaint.getId());
        dto.setIssueType(complaint.getIssueType());
        dto.setDescription(complaint.getDescription());
        dto.setStatus(complaint.getStatus());
        return dto;
    }
}
