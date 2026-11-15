package com.taskmanager.task_manager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "tag_name", nullable = false, columnDefinition = "TEXT")
    private String tagName;

    @Column(name = "tag_colour", nullable = false, columnDefinition = "TEXT")
    private String tagColour;

    public Long getTagId() {
        return tagId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagColour() {
        return tagColour;
    }

    public void setTagColour(String tagColour) {
        this.tagColour = tagColour;
    }
}
