package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;
import com.complaint_mngmt.maintenance.exception.ResourceNotFoundException;
import com.complaint_mngmt.maintenance.model.Complaint;
import com.complaint_mngmt.maintenance.model.User;
import com.complaint_mngmt.maintenance.repository.ComplaintRepository;
import com.complaint_mngmt.maintenance.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository, UserRepository userRepository) {
        this.complaintRepository = complaintRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ComplaintDTO createComplaint(ComplaintDTO complaintDTO) {
        Complaint complaint = new Complaint();
        // Map DTO to entity
        complaint.setIssueType(complaintDTO.getIssueType());
        complaint.setDescription(complaintDTO.getDescription());
        complaint.setStatus(complaintDTO.getStatus());

        // Associate user if userId is provided
        if (complaintDTO.getUserId() != null) {
            User user = userRepository.findById(complaintDTO.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found")).getUser();
            complaint.setUser(user);
        }

        // Save entity
        Complaint saved = complaintRepository.save(complaint);
        // Map entity to DTO
        return mapToDTO(saved);
    }

    @Override
    public ComplaintDTO getComplaintById(Long id) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
        return mapToDTO(complaint);
    }

    @Override
    public List<ComplaintDTO> getAllComplaintsByUser(Long userId) {
        // If you store userId in the complaint, filter by userId
        List<Complaint> complaints = complaintRepository.findAll();
        return complaints.stream()
                .filter(c -> c.getUser() != null && c.getUser().getId().equals(userId))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ComplaintDTO mapToDTO(Complaint complaint) {
        ComplaintDTO dto = new ComplaintDTO();
        dto.setId(complaint.getId());
        dto.setIssueType(complaint.getIssueType());
        dto.setDescription(complaint.getDescription());
        dto.setStatus(complaint.getStatus());
        if (complaint.getUser() != null) {
            dto.setUserId(complaint.getUser().getId());
        }
        if (complaint.getAssignedTechnician() != null) {
            dto.setAssignedTechnicianId(complaint.getAssignedTechnician().getId());
        }
        return dto;
    }
}