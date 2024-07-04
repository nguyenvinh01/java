package com.example.demo_java.dto.request;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserCreationRequest {
    private String id;
    private String username;

    @Size(min = 6, message = "It nhat 6 ky tu")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public @Size(min = 6, message = "It nhat 6 ky tu") String getPassword() {
//        return password;
//    }
//
//    public void setPassword(@Size(min = 6, message = "It nhat 6 ky tu") String password) {
//        this.password = password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
}
