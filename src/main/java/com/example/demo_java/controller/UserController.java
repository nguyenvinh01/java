package com.example.demo_java.controller;

import com.example.demo_java.dto.request.ApiResponse;
import com.example.demo_java.dto.request.UserCreationRequest;
import com.example.demo_java.dto.request.UserUpdateRequest;
import com.example.demo_java.entity.User;
import com.example.demo_java.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

//    @GetMapping("")
//    ApiResponse<List<User>> getUserList() {
//        ApiResponse<List<User>> apiResponse = new ApiResponse<>();
//
//        return apiResponse.setResult(userService.getUserList());
//    }

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
}
