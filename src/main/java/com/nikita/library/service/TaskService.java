package com.nikita.library.service;

import com.nikita.library.entity.Task;
import com.nikita.library.repo.TaskRepository;
import com.nikita.library.search.TaskSearchValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getTask(){
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void update(Task task){ taskRepository.save(task);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

    public Page<Task> search(TaskSearchValues taskSearchValues){
        String title = taskSearchValues.getText() != null ? taskSearchValues.getText() : null;
        Integer completed = taskSearchValues.getCompleted() != null ? taskSearchValues.getCompleted() : null;
        Long priorityId = taskSearchValues.getPriorityId() != null ? taskSearchValues.getPriorityId() : null;
        Long categoryId = taskSearchValues.getCategoryId() != null ? taskSearchValues.getCategoryId() : null;

        String sortColumn = taskSearchValues.getSortColumn() != null ? taskSearchValues.getSortColumn() : null;
        String sortDirection = taskSearchValues.getSortDirection() != null ? taskSearchValues.getSortDirection() : null;

        Sort.Direction direction = sortDirection == null || sortDirection.trim().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort = Sort.by(direction, sortColumn);

        PageRequest pageRequest = PageRequest.of(taskSearchValues.getPageNumber(), taskSearchValues.getPageSize());
        Page result = taskRepository.findByParams(title, completed, priorityId, categoryId, pageRequest);

        return result;
    }
}
