package com.nikita.library.service;

import com.nikita.library.entity.Stat;
import com.nikita.library.repo.StatRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class StatService {

    private StatRepository statRepository;

    public Stat findByOne(){
        Long id = 1L;
        return statRepository.findById(id).get();
    }
}
