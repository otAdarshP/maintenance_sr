package com.complaint_mngmt.maintenance.repository;

import com.complaint_mngmt.maintenance.model.Complaint;
import com.complaint_mngmt.maintenance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    // Custom query methods can be added here
}
