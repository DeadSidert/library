package com.nikita.library.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

public class Priority {
    private Long id;
    private String title;
    private String color;
    private Collection<Task> tasksById;

    @Id
    @Column(name = "id", table = "priority", nullable = false)
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "title", table = "priority", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "color", table = "priority", nullable = false, length = 45)
    public String getColor() {
        return color;
    }


    @OneToMany(mappedBy = "priorityByPriorityId")
    public Collection<Task> getTasksById() {
        return tasksById;
    }

}
