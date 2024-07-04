package com.example.demo_java.controller;

import com.example.demo_java.dto.request.AuthenticateRequest;
import com.example.demo_java.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    boolean login(@RequestBody AuthenticateRequest request) {
        return authService.authenticate(request);
    }
}
