package com.taskmanager.task_manager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "cat_name", nullable = false, columnDefinition = "TEXT")
    private String catName;

    @Column(name = "cat_colour", nullable = false, columnDefinition = "TEXT")
    private String catColour;

    public Long getCategoryId() {
        return categoryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatColour() {
        return catColour;
    }

    public void setCatColour(String catColour) {
        this.catColour = catColour;
    }
}
