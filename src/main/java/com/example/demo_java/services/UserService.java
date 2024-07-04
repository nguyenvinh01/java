package com.example.demo_java.services;

import com.example.demo_java.dto.request.UserCreationRequest;
import com.example.demo_java.dto.request.UserUpdateRequest;
import com.example.demo_java.entity.User;
import com.example.demo_java.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
//        return user;
        return userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
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
