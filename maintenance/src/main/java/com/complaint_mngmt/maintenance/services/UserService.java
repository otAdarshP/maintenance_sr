package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserByEmail(String email);
}