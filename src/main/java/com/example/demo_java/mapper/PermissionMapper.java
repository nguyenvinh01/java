package com.example.demo_java.mapper;

import com.example.demo_java.dto.request.PermissionRequest;
import com.example.demo_java.dto.response.PermissionResponse;
import com.example.demo_java.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}