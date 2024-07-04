package com.example.demo_java.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_EXISTED(1000, "Trung tai khoan")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private int code;
    private  String message;

//    public int getCode() {
//        return code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
}
