package com.example.demo_java.services;

import com.example.demo_java.dto.request.AuthenticateRequest;
import com.example.demo_java.entity.User;
import com.example.demo_java.exception.AppException;
import com.example.demo_java.exception.ErrorCode;
import com.example.demo_java.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public boolean authenticate(AuthenticateRequest request) {
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new AppException(ErrorCode.USER_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
