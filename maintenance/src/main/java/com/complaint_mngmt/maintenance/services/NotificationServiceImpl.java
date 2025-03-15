package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.model.Complaint;
import com.complaint_mngmt.maintenance.model.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void notifyUser(User user, String message) {
        // Implementation for sending notification to user
        System.out.println("Notification sent to user: " + user.getEmail() + " - " + message);
    }

    @Override
    public void notifyAdminOfNewComplaint(Complaint complaint) {
        // Implementation for notifying admin of new complaint
        System.out.println("Admin notified of new complaint: " + complaint.getId());
    }

    @Override
    public void notifyUserOfStatusChange(Complaint complaint) {
        // Implementation for notifying user of status change
        System.out.println("User notified of status change for complaint: " + complaint.getId() + " - " + complaint.getStatus());
    }
}