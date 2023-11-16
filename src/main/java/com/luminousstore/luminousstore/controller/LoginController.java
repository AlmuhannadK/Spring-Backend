package com.luminousstore.luminousstore.controller;

import com.luminousstore.luminousstore.service.Impl.LoginServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {

    private final LoginServiceImpl loginService;
}
