package com.taskmanager.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmanager.task_manager.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
