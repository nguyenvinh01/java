package com.example.demo_java.controller;

import com.example.demo_java.dto.request.ApiResponse;
import com.example.demo_java.dto.request.AuthenticateRequest;
import com.example.demo_java.dto.response.AuthenticationResponse;
import com.example.demo_java.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticateRequest request) {
        boolean result = authService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();    }
}
