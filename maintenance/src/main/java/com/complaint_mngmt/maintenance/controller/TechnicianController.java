package com.complaint_mngmt.maintenance.controller;

import com.complaint_mngmt.maintenance.dto.ComplaintDTO;
import com.complaint_mngmt.maintenance.services.TechnicianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technician")
public class TechnicianController {

    private final TechnicianService technicianService;

    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @PutMapping("/complaints/{id}/resolve")
    public ResponseEntity<ComplaintDTO> resolveComplaint(@PathVariable Long id) {
        ComplaintDTO resolved = technicianService.resolveComplaint(id);
        return ResponseEntity.ok(resolved);
    }
}
