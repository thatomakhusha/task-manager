package com.taskmanager.task_manager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "task_tags")
public class TaskTag {

    @EmbeddedId
    private TaskTagId id;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public TaskTag() {

    }

    public TaskTag(Task task, Tag tag) {
        this.task = task;
        this.tag = tag;
        this.id = new TaskTagId(task.getTaskId(), tag.getTagId());
    }

    public TaskTagId getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
