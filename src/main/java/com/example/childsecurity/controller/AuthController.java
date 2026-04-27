package com.example.childsecurity.controller;

import com.example.childsecurity.model.User;
import com.example.childsecurity.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.registerParent(request.getEmail(), request.getPassword());
    }

    @Data
    static class RegisterRequest {
        private String email;
        private String password;
    }
}
