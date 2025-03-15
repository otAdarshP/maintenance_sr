package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;
import com.complaint_mngmt.maintenance.exception.ResourceNotFoundException;
import com.complaint_mngmt.maintenance.model.Complaint;
import com.complaint_mngmt.maintenance.model.IssueStatus;
import com.complaint_mngmt.maintenance.model.Technician;
import com.complaint_mngmt.maintenance.repository.ComplaintRepository;
import com.complaint_mngmt.maintenance.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final ComplaintRepository complaintRepository;
    private final TechnicianRepository technicianRepository;

    public AdminServiceImpl(ComplaintRepository complaintRepository,
                            TechnicianRepository technicianRepository) {
        this.complaintRepository = complaintRepository;
        this.technicianRepository = technicianRepository;
    }

    @Override
    public List<ComplaintDTO> getAllComplaints() {
        return complaintRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ComplaintDTO assignTechnician(Long complaintId, Long technicianId) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
        Technician technician = technicianRepository.findById(technicianId)
                .orElseThrow(() -> new ResourceNotFoundException("Technician not found")).getAssignedTechnician();

        complaint.setAssignedTechnician(technician);
        complaint.setStatus(IssueStatus.IN_PROGRESS);
        complaintRepository.save(complaint);

        return mapToDTO(complaint);
    }

    @Override
    public ComplaintDTO rejectComplaint(Long complaintId) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
        complaint.setStatus(IssueStatus.REJECTED); // Change to a REJECTED status
        complaintRepository.save(complaint);

        return mapToDTO(complaint);
    }

    private ComplaintDTO mapToDTO(Complaint complaint) {
        ComplaintDTO dto = new ComplaintDTO();
        dto.setId(complaint.getId());
        dto.setIssueType(complaint.getIssueType());
        dto.setDescription(complaint.getDescription());
        dto.setStatus(complaint.getStatus());
        if (complaint.getAssignedTechnician() != null) {
            dto.setAssignedTechnicianId(complaint.getAssignedTechnician().getId());
        }
        return dto;
    }
}