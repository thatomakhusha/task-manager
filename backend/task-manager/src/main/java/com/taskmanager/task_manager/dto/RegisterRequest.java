package com.taskmanager.task_manager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank
    @Size(max = 50, message = "First name cannot exceed 50 characters.")
    private String firstName;

    @NotBlank
    @Size(max = 50, message = "Last name cannot exceed 50 characters.")
    private String lastName;

    @NotBlank
    @Email
    @Size(max = 255, message = "Email cannot exceed 255 characters.")
    private String email;

    @NotBlank
    @Size(min = 8, message = "Password must contain at least 8 characters.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$",
            message = "Password must contain an uppercase letter, lowercase letter, number and special character."
    )
    private String password;

    @NotBlank
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}