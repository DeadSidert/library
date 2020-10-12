package com.nikita.library.controllers;

import com.nikita.library.entity.Priority;
import com.nikita.library.repo.PriorityRepository;
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
    public Priority addPriority(@RequestBody Priority priority){
        return priorityRepository.save(priority);
    }



}
