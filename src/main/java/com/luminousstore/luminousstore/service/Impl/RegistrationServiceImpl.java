package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.repository.UserRepository;
import com.luminousstore.luminousstore.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;


    // Add data validations (email, username are not repeated in the database, etc)
    public UserDTO registerUser(UserDTO user) {
        return null;
    }
}
