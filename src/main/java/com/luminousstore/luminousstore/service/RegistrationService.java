package com.luminousstore.luminousstore.service;

import com.luminousstore.luminousstore.dto.UserDTO;

import java.util.Optional;

public interface RegistrationService {

    UserDTO registerUser(UserDTO user);
}
