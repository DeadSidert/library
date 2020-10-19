package com.nikita.library.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class TaskSearchValues {

    private String text;
    private int completed;
    private Long priorityId;
    private Long categoryId;

}
