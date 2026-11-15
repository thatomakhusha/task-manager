package com.taskmanager.task_manager.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenService {

    private final SecureRandom secureRandom = new SecureRandom();

    public byte[] generateTokenBytes() {
        byte[] token = new byte[32];
        secureRandom.nextBytes(token);
        return token;
    }

    public String generateToken() {
        byte[] token = generateTokenBytes();

        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(token);
    }

    public String hashToken(String token) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedToken = digest.digest(token.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(hashedToken);
    }
}
