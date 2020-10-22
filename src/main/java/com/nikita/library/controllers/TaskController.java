package com.nikita.library.controllers;

import com.nikita.library.entity.Task;
import com.nikita.library.search.TaskSearchValues;
import com.nikita.library.service.TaskService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;


    @GetMapping("/get")
    public ResponseEntity<List<Task>> getTask(){
        List<Task> tasks = taskService.getTask();
        System.out.println("list:" + tasks);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task){

        if(task.getId() != null || task.getId() != 0){
            return new ResponseEntity("ID передавать не нужно", HttpStatus.NOT_ACCEPTABLE);
        }
        if (task.getTitle() == null || task.getTitle().trim().length() == 0){
            return new ResponseEntity("Название обязательно", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(taskService.save(task));
    }

    @PutMapping("/update")
    public ResponseEntity<Task> update(@RequestBody Task task){

        if (task.getId() == null || task.getId() == 0){
            return new ResponseEntity("ID передавать нужно", HttpStatus.NOT_ACCEPTABLE);
        }
        if (task.getTitle() == null || task.getTitle().trim().length() == 0){
            return new ResponseEntity("Название обязательно", HttpStatus.NOT_ACCEPTABLE);
        }
        taskService.update(task);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try {
            taskService.deleteById(id);
        }catch (EmptyResultDataAccessException e ){
            return new ResponseEntity("id " + id + " не найден", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<Page<Task>> search(@RequestBody TaskSearchValues taskSearchValues){
        return ResponseEntity.ok(taskService.search(taskSearchValues));
    }
}
