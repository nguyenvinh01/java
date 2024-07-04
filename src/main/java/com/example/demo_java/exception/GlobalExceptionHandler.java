package com.example.demo_java.exception;

import com.example.demo_java.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> handleRunTimeException(RuntimeException exception) {
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setCode(400);
        apiResponse.setResult(exception.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setCode(400);
        apiResponse.setMessage(exception.getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(apiResponse);

    }
}
