package com.complaint_mngmt.maintenance.repository;

import com.complaint_mngmt.maintenance.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // Custom query methods can be added here
}
