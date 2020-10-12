package com.nikita.library.entity;

import javax.persistence.*;
import java.sql.Timestamp;

public class Task {
    private Long id;
    private String title;
    private Integer completed;
    private Timestamp date;
    private Long priorityId;
    private Long categoryId;
    private Priority priorityByPriorityId;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "id", table = "task", nullable = false)
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "title", table = "task", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "completed", table = "task", nullable = true)
    public Integer getCompleted() {
        return completed;
    }

    @Basic
    @Column(name = "date", table = "task", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    @Basic
    @Column(name = "priority_id", table = "task", nullable = true)
    public Long getPriorityId() {
        return priorityId;
    }

    @Basic
    @Column(name = "category_id", table = "task", nullable = true)
    public Long getCategoryId() {
        return categoryId;
    }

}