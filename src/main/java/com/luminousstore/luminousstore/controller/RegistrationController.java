package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.service.Impl.RegistrationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Validated --> works like @Valid but for class-level (all methods included)
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationServiceImpl registrationService;


    @PostMapping(path = "/registration")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(this.registrationService.registerUser(user));
    }

    // TESTING FOR EXCEPTION HANDLING
    @GetMapping("/{id}")
    public ResponseEntity<User> getRegisteredUserById(@Valid @PathVariable("id") Long id) {
        return ResponseEntity.ok(this.registrationService.getRegisteredUserById(id));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getRegisteredUsers() {
        return ResponseEntity.ok(this.registrationService.getRegisteredUsers());
    }

}
