package com.taskmanager.task_manager.repository;

import com.taskmanager.task_manager.entity.Notification;
import com.taskmanager.task_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUser(User user);
    List<Notification> findByUserAndIsReadFalse(User user);
}
