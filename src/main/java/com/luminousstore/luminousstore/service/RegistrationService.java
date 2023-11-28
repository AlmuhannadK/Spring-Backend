package com.luminousstore.luminousstore.service;

import com.luminousstore.luminousstore.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {

    ResponseEntity<UserDTO> registerUser(UserDTO user);


}
