package com.taskmanager.task_manager.repository;

import com.taskmanager.task_manager.entity.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmailVerificationRepository extends JpaRepository<EmailVerification, Long> {
    Optional<EmailVerification> findByTokenHash(String tokenHash);
}
