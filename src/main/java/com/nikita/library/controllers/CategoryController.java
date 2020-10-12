package com.nikita.library.controllers;

import com.nikita.library.entity.Category;
import com.nikita.library.repo.CategoryRepository;
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
    public Category addCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
