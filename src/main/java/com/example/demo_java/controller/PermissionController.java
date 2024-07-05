package com.example.demo_java.controller;

import com.example.demo_java.dto.request.ApiResponse;
import com.example.demo_java.dto.request.PermissionRequest;
import com.example.demo_java.dto.response.PermissionResponse;
import com.example.demo_java.entity.Permission;
import com.example.demo_java.services.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/permissions")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {

//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    PermissionService permissionService;

    @GetMapping("")
    ApiResponse<List<PermissionResponse>> getPermissions() {
        List<PermissionResponse> permissions = permissionService.getAll();

        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissions)
                .build();
    }

    @PostMapping("/create")
    ApiResponse<PermissionResponse> create(@RequestBody PermissionRequest request) {
        PermissionResponse permission = permissionService.create(request);
        return ApiResponse.<PermissionResponse>builder().result(permission).build();
    }
}
