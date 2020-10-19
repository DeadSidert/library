package com.nikita.library.controllers;

import com.nikita.library.entity.Stat;
import com.nikita.library.repo.StatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stat")
public class StatController {

    private StatRepository statRepository;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public StatController() {
    }

    @GetMapping("/find_one")
    public ResponseEntity<Stat> findByOne(){
        Long id = 1L;
        return ResponseEntity.ok(statRepository.findById(id).get());
    }
}
