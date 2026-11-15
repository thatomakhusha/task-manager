package com.taskmanager.task_manager.service;

import com.taskmanager.task_manager.dto.RegisterRequest;
import com.taskmanager.task_manager.entity.User;
import org.springframework.stereotype.Service;
import com.taskmanager.task_manager.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.taskmanager.task_manager.repository.EmailVerificationRepository;
import com.taskmanager.task_manager.entity.EmailVerification;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final VerificationTokenService verificationTokenService;
    private final EmailVerificationRepository emailVerificationRepository;

    private final EmailService emailService;

    public UserService(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder,
            VerificationTokenService verificationTokenService,
            EmailVerificationRepository emailVerificationRepository,
            EmailService emailService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenService = verificationTokenService;
        this.emailVerificationRepository = emailVerificationRepository;
        this.emailService = emailService;
    }

    @Transactional
    public void registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(hashedPassword);

        userRepository.save(user);

        String verificationToken = verificationTokenService.generateToken();

        String hashedVerificationToken;

        try {
            hashedVerificationToken = verificationTokenService.hashToken(verificationToken);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Unable to hash verification token.", e);
        }

        EmailVerification emailVerification = new EmailVerification();

        emailVerification.setUser(user);
        emailVerification.setTokenHash(hashedVerificationToken);
        emailVerification.setExpiresAt(OffsetDateTime.now().plusHours(24));

        emailVerificationRepository.save(emailVerification);
        emailService.sendVerificationEmail(user.getEmail(), verificationToken);
    }
}
