package com.taskmanager.task_manager.repository;

import com.taskmanager.task_manager.entity.PasswordReset;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long>{
    Optional<PasswordReset> findByTokenHash(String tokenHash);
}
