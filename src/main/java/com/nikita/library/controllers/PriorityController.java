package com.nikita.library.controllers;

import com.nikita.library.entity.Priority;
import com.nikita.library.repo.PriorityRepository;
import com.nikita.library.search.PrioritySearchValues;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }
    public PriorityController() {
    }

    @GetMapping("/get")
    public List<Priority> getPriority(){
        List<Priority> priorities = priorityRepository.findAll();
        System.out.println("list:" + priorities);
        return priorities;
    }
    @PostMapping("/add")
    public ResponseEntity<Priority> addPriority(@RequestBody Priority priority){

        if(priority.getId() != null || priority.getId() != 0){
            return new ResponseEntity("ID передавать не нужно", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("Название обязательно", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> update(@RequestBody Priority priority){

        if (priority.getId() == null || priority.getId() == 0){
            return new ResponseEntity("ID передавать нужно", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("Название обязательно", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try {
            priorityRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e ){
            return new ResponseEntity("id " + id + " не найден", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Priority>> search(@RequestBody PrioritySearchValues prioritySearchValues){
        return ResponseEntity.ok(priorityRepository.findByTitle(prioritySearchValues.getText()));
    }
}
