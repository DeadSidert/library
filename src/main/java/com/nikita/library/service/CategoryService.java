package com.nikita.library.service;

import com.nikita.library.entity.Category;
import com.nikita.library.repo.CategoryRepository;
import com.nikita.library.search.CategorySearchValues;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;

    public List<Category> getCategory(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public void update(Category category){
        categoryRepository.save(category);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }

    public List<Category> search(CategorySearchValues categorySearchValues){
        return categoryRepository.findByTitle(categorySearchValues.getText());
    }
}
