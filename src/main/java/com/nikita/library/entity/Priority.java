package com.nikita.library.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Priority {
    private Long id;
    private String title;
    private String color;

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

}
