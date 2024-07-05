package com.example.demo_java.controller;

import com.example.demo_java.dto.request.ApiResponse;
import com.example.demo_java.dto.request.AuthenticateRequest;
import com.example.demo_java.dto.request.IntrospectRequest;
import com.example.demo_java.dto.response.AuthenticationResponse;
import com.example.demo_java.dto.response.IntrospectResponse;
import com.example.demo_java.services.AuthService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticateRequest request) {
        AuthenticationResponse result = authService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> login(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        IntrospectResponse result = authService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
