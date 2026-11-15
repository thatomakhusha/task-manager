package com.taskmanager.task_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

import java.util.Objects;

@Embeddable
public class TaskTagId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "tag_id")
    private Long tagId;

    public TaskTagId(){

    }

    public TaskTagId(Long taskId, Long tagId) {
        this.taskId = taskId;
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskTagId taskTagId = (TaskTagId) o;
        return Objects.equals(taskId, taskTagId.taskId) && Objects.equals(tagId, taskTagId.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, tagId);
    }
}
