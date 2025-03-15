package com.complaint_mngmt.maintenance.controller;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;
import com.complaint_mngmt.maintenance.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/complaints")
    public ResponseEntity<List<ComplaintDTO>> getAllComplaints() {
        List<ComplaintDTO> complaints = adminService.getAllComplaints();
        return ResponseEntity.ok(complaints);
    }

    @PutMapping("/complaints/{id}/assign/{technicianId}")
    public ResponseEntity<ComplaintDTO> assignTechnician(@PathVariable Long id,
                                                         @PathVariable Long technicianId) {
        ComplaintDTO updatedComplaint = adminService.assignTechnician(id, technicianId);
        return ResponseEntity.ok(updatedComplaint);
    }

    @PutMapping("/complaints/{id}/reject")
    public ResponseEntity<ComplaintDTO> rejectComplaint(@PathVariable Long id) {
        ComplaintDTO rejectedComplaint = adminService.rejectComplaint(id);
        return ResponseEntity.ok(rejectedComplaint);
    }
}
