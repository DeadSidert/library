package com.nikita.library.repo;

import com.nikita.library.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

    @Query("SELECT p FROM Priority p where " +
            "(:title is null or :title='' or lower(p.title) like lower(concat('%', :title, '%')))" +
            "ORDER BY p.title ASC ")
    List<Priority> findByTitle(@Param("title")String title);
}
