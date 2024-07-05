package com.example.demo_java.mapper;

import com.example.demo_java.dto.request.UserCreationRequest;
import com.example.demo_java.dto.request.UserUpdateRequest;
import com.example.demo_java.dto.response.UserResponse;
import com.example.demo_java.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}