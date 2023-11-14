package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.service.Impl.RegistrationServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Validated --> works like @Valid but for class-level (all methods included)
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@Validated
public class RegistrationController {

    private final RegistrationServiceImpl registrationService;


    @PostMapping(path = "/registration")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(this.registrationService.registerUser(user));
    }

    // TESTING FOR EXCEPTION HANDLING
    // validate path variables and request parameters via annotations directly
    // since these are not objects, but need to add @Validated at class-level
    @GetMapping("/{id}")
    public ResponseEntity<User> getRegisteredUserById(@PathVariable("id") @Min(1) Long id) {
        return ResponseEntity.ok(this.registrationService.getRegisteredUserById(id));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getRegisteredUsers() {
        return ResponseEntity.ok(this.registrationService.getRegisteredUsers());
    }

}
