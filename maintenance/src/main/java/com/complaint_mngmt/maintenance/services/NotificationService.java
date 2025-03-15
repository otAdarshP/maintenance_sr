package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.model.Complaint;
import com.complaint_mngmt.maintenance.model.User;

public interface NotificationService {
    void notifyUser(User user, String message);
    void notifyAdminOfNewComplaint(Complaint complaint);
    void notifyUserOfStatusChange(Complaint complaint);
}