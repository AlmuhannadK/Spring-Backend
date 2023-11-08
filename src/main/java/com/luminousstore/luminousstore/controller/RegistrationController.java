package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.service.Impl.RegistrationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationServiceImpl registrationService;

    /*

    Demo

    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO newuser) {

        return ResoponseEntity.ok(this.registartionService.registerUser(newuser);
    }
     */
}
