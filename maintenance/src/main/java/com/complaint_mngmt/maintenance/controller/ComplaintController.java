package com.complaint_mngmt.maintenance.controller;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;
import com.complaint_mngmt.maintenance.services.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public ResponseEntity<ComplaintDTO> createComplaint(@RequestBody ComplaintDTO complaintDTO) {
        ComplaintDTO created = complaintService.createComplaint(complaintDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplaintDTO> getComplaint(@PathVariable Long id) {
        ComplaintDTO complaint = complaintService.getComplaintById(id);
        return ResponseEntity.ok(complaint);
    }
}
