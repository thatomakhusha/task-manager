package com.taskmanager.task_manager.repository;

import com.taskmanager.task_manager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUserUserId(Long userId);
}
