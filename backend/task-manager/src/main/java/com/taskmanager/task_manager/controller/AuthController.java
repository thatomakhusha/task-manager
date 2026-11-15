package com.taskmanager.task_manager.controller;

import com.taskmanager.task_manager.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.task_manager.service.UserService;
import com.taskmanager.task_manager.service.EmailVerificationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.NoSuchAlgorithmException;

import com.taskmanager.task_manager.dto.ApiResponse;

@RestController
public class AuthController {

    private final UserService userService;
    private final EmailVerificationService emailVerificationService;

    public AuthController(
            UserService userService,
            EmailVerificationService emailVerificationService
    ) {
        this.userService = userService;
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/api/auth/register")
    public ApiResponse register(@Valid @RequestBody RegisterRequest request) {
        userService.registerUser(request);
        return new ApiResponse(true, "Registration successful. Please check your email to verify your account.");
    }

    @GetMapping("/api/auth/verify-email")
    public ApiResponse verifyEmail(@RequestParam String token) throws NoSuchAlgorithmException {

        emailVerificationService.verifyEmail(token);

        return new ApiResponse(true, "Email verified successfully. You can now log in.");
    }
}
