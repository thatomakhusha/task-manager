package com.taskmanager.task_manager.repository;

import com.taskmanager.task_manager.entity.Subtask;
import com.taskmanager.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
    List<Subtask> findByTask(Task task);
}
