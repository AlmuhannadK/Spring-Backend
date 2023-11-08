package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.service.Impl.RegistrationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationServiceImpl registrationService;


    @PostMapping(path = "/registration")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(this.registrationService.registerUser(user));
    }

}
