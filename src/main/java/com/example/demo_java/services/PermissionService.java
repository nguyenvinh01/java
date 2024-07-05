package com.example.demo_java.services;

import com.example.demo_java.dto.request.PermissionRequest;
import com.example.demo_java.dto.response.PermissionResponse;
import com.example.demo_java.entity.Permission;
import com.example.demo_java.mapper.PermissionMapper;
import com.example.demo_java.repositories.PermissionRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    @Autowired
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;


    public PermissionResponse create(PermissionRequest request) {
//        Permission permission = permissionMapper.toPermission(request);
        Permission permission = new Permission();
        permission.setName(request.getName());
        permission.setDescription(request.getDescription());
    PermissionResponse permissionResponse = new PermissionResponse();
        permission = permissionRepository.save(permission);

        permissionResponse.setName(permission.getName());
        permissionResponse.setDescription(permission.getDescription());
        return permissionResponse;
    }
    public List<PermissionResponse> getAll(){
        List<Permission> permissions = permissionRepository.findAll();
        List<PermissionResponse> listPermission = permissions.stream()
                .map(p -> {
                    PermissionResponse permissionResponse = new PermissionResponse();
                    permissionResponse.setName(p.getName());
                    permissionResponse.setDescription(p.getDescription());
                    return permissionResponse;
                })
                .toList();
        return listPermission;
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
