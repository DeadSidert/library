package com.nikita.library.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

public class Category {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;
    private Collection<Task> tasksById;

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
    @Column(name = "completed_count", table = "category", nullable = true)
    public Long getCompletedCount() {
        return completedCount;
    }

    @Basic
    @Column(name = "uncompleted_count", table = "category", nullable = true)
    public Long getUncompletedCount() {
        return uncompletedCount;
    }


    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Task> getTasksById() {
        return tasksById;
    }

}
