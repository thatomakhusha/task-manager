package com.taskmanager.task_manager.controller;

import com.taskmanager.task_manager.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.taskmanager.task_manager.service.UserService;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/auth/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        userService.registerUser(request);
        return "Registration successful.";
    }
}
