package com.complaint_mngmt.maintenance.services;

import com.complaint_mngmt.maintenance.dto.UserDTO;
import com.complaint_mngmt.maintenance.exception.ResourceNotFoundException;
import com.complaint_mngmt.maintenance.model.User;
import com.complaint_mngmt.maintenance.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword()); // in real-world, encode the password
        // Set other fields as needed
        userRepository.save(user);
        return mapToDTO(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }
        return mapToDTO(user);
    }

    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        // Map other fields as needed
        return dto;
    }
}