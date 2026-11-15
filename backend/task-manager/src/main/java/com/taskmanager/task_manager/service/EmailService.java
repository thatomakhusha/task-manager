package com.taskmanager.task_manager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmailService.class);

    public void sendVerificationEmail(String email, String verificationToken) {

        String verificationLink =
                "http://localhost:8080/api/auth/verify-email?token="
                        + verificationToken;

        logger.info("DEVELOPMENT ONLY: Email verification link for {}: {}",
                email, verificationLink);
    }
}
