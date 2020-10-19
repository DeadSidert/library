package com.nikita.library.controllers;

import com.nikita.library.entity.Priority;
import com.nikita.library.entity.Task;
import com.nikita.library.repo.TaskRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskController() {
    }

    @GetMapping("/get")
    public List<Task> getTask(){
        List<Task> tasks = taskRepository.findAll();
        System.out.println("list:" + tasks);
        return tasks;
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task){

        if(task.getId() != null || task.getId() != 0){
            return new ResponseEntity("ID передавать не нужно", HttpStatus.NOT_ACCEPTABLE);
        }
        if (task.getTitle() == null || task.getTitle().trim().length() == 0){
            return new ResponseEntity("Название обязательно", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(taskRepository.save(task));
    }

    @PutMapping("/update")
    public ResponseEntity<Task> update(@RequestBody Task task){

        if (task.getId() == null || task.getId() == 0){
            return new ResponseEntity("ID передавать нужно", HttpStatus.NOT_ACCEPTABLE);
        }
        if (task.getTitle() == null || task.getTitle().trim().length() == 0){
            return new ResponseEntity("Название обязательно", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try {
            taskRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e ){
            return new ResponseEntity("id " + id + " не найден", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
