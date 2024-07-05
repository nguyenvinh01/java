package com.example.demo_java.controller;

import com.example.demo_java.dto.request.ApiResponse;
import com.example.demo_java.dto.request.UserCreationRequest;
import com.example.demo_java.dto.request.UserUpdateRequest;
import com.example.demo_java.entity.User;
import com.example.demo_java.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController {

//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("")
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping("")
    ApiResponse<List<User>> getUserList() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Get user", authentication.getName());
        authentication.getAuthorities().forEach(auth -> {
            log.info("role: ", auth);
        });
        List<User> users = userService.getUserList();
        return ApiResponse.<List<User>>builder().result(users).build();
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable String id) {
//        return id;
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable("id") String id, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable("id") String id) {
        userService.deleteUSer(id);
        return "User delete success";
    }

    @GetMapping("/myinfo")
    User getMyInfo() {
        return userService.getInfo();
    }
}
