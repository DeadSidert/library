package com.nikita.library.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;

    @Id
    @Column(name = "id", table = "category", nullable = false)
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "title", table = "category", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "completed_count", table = "category")
    public Long getCompletedCount() {
        return completedCount;
    }

    @Basic
    @Column(name = "uncompleted_count", table = "category")
    public Long getUncompletedCount() {
        return uncompletedCount;
    }


}
