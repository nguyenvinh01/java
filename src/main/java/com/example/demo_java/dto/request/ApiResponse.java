package com.example.demo_java.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse<T> {
    private int code = 200;
    private String message;
    private T result;
}
