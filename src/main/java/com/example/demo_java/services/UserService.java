package com.example.demo_java.services;

import com.example.demo_java.dto.request.UserCreationRequest;
import com.example.demo_java.dto.request.UserUpdateRequest;
import com.example.demo_java.dto.response.UserResponse;
import com.example.demo_java.entity.User;
import com.example.demo_java.enums.Role;
import com.example.demo_java.exception.AppException;
import com.example.demo_java.exception.ErrorCode;
import com.example.demo_java.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

//        if(userRepository.existsByUsername(request.getUsername())) {
//            throw new AppException(ErrorCode.USER_EXISTED);
//        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        user.setFirstName(request.getFirstName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());

//        user.setRoles(roles);
        return userRepository.save(user);
    }
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public User getInfo() {
//        SecurityContextHolder securityContextHolder = new SecurityContextHolder();

        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
        return user;
    }
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String id, UserUpdateRequest request) {
        User user = getUser(id);

        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
//        return user;
        return userRepository.save(user);
    }

    public void deleteUSer(String id) {
        userRepository.deleteById(id);
    }
}
