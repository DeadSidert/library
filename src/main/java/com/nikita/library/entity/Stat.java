package com.nikita.library.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stat {
    private Long id;
    private Long completedTotal;
    private Long uncompletedTotal;

    @Id
    @Column(name = "id", table = "stat", nullable = false)
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "completed_total", table = "stat")
    public Long getCompletedTotal() {
        return completedTotal;
    }

    @Basic
    @Column(name = "uncompleted_total", table = "stat")
    public Long getUncompletedTotal() {
        return uncompletedTotal;
    }

}
