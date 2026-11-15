package com.taskmanager.task_manager.repository;

import com.taskmanager.task_manager.entity.TaskTag;
import com.taskmanager.task_manager.entity.TaskTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTagId> {
    List<TaskTag> findByTaskTaskId(Long taskId);
}
