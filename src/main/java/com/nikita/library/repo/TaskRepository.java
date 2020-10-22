package com.nikita.library.repo;

import com.nikita.library.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t where " +
            "(:title is null or :title='' or lower(t.title) like lower(concat('%', :title, '%'))) and" +
            "(:completed is null or t.completed=:completed) and " +
            "(:priorityId is null or t.priorityId=:priorityId)and" +
            "(:categoryId is null or t.categoryId=:categoryId)")
    Page<Task> findByParams(@Param("title")String title, @Param("completed") Integer completed,
                            @Param("priorityId") Long priorityId, @Param("categoryId") Long categoryId, Pageable pageable);

}
