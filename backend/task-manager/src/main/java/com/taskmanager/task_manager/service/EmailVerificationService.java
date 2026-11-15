package com.taskmanager.task_manager.service;

import org.springframework.stereotype.Service;
import com.taskmanager.task_manager.repository.EmailVerificationRepository;
import java.security.NoSuchAlgorithmException;
import com.taskmanager.task_manager.entity.EmailVerification;
import java.util.Optional;
import java.time.OffsetDateTime;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailVerificationService {

    private final EmailVerificationRepository emailVerificationRepository;
    private final VerificationTokenService verificationTokenService;

    public EmailVerificationService(
            EmailVerificationRepository emailVerificationRepository,
            VerificationTokenService verificationTokenService) {

        this.emailVerificationRepository = emailVerificationRepository;
        this.verificationTokenService = verificationTokenService;
    }

    @Transactional
    public void verifyEmail(String token) throws NoSuchAlgorithmException {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Verification token is required.");
        }

        String hashedToken = verificationTokenService.hashToken(token);

        Optional<EmailVerification> verificationOptional =
                emailVerificationRepository.findByTokenHashAndVerifiedAtIsNull(hashedToken);

        if (verificationOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid or already used verification token.");
        }

        EmailVerification verification = verificationOptional.get();

        if (verification.getExpiresAt().isBefore(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Verification token has expired.");
        }

        verification.setVerifiedAt(OffsetDateTime.now());

        verification.getUser().setEmailVerified(true);
    }

}
