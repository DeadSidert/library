package com.nikita.library.service;

import com.nikita.library.entity.Priority;
import com.nikita.library.repo.PriorityRepository;
import com.nikita.library.search.PrioritySearchValues;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PriorityService {

    private PriorityRepository priorityRepository;

    public List<Priority> getPriority(){
        List<Priority> priorities = priorityRepository.findAll();
        return priorities;
    }

    public Priority addPriority(Priority priority){
        return priorityRepository.save(priority);
    }

    public void update(Priority priority){
        priorityRepository.save(priority);
    }

    public void deleteById(Long id){
        priorityRepository.deleteById(id);
    }

    public List<Priority> search(PrioritySearchValues prioritySearchValues){
        return priorityRepository.findByTitle(prioritySearchValues.getText());
    }

}
