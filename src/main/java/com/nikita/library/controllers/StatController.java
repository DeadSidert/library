package com.nikita.library.controllers;

import com.nikita.library.entity.Stat;
import com.nikita.library.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stat")
public class StatController {

    private StatService statService;

    @GetMapping("/find_one")
    public ResponseEntity<Stat> findByOne(){
        return ResponseEntity.ok(statService.findByOne());
    }
}
