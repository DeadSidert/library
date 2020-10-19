package com.nikita.library.controllers;

import com.nikita.library.entity.Category;
import com.nikita.library.repo.CategoryRepository;
import com.nikita.library.search.CategorySearchValues;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryController() {
    }

    @GetMapping("/get")
    public List<Category> getCategory(){

        List<Category> categories = categoryRepository.findAll();
        System.out.println("list:" + categories);
        return categories;

    }


    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){

        if (category.getId() != null || category.getId() != 0){
            return new ResponseEntity("ID передавать не нужно", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("Название обязательно", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category){

        if (category.getId() == null || category.getId() == 0){
            return new ResponseEntity("ID передавать нужно", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("Название обязательно", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try {
            categoryRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e ){
            return new ResponseEntity("id " + id + " не найден", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearchValues categorySearchValues){
        return ResponseEntity.ok(categoryRepository.findByTitle(categorySearchValues.getText()));
    }

}
