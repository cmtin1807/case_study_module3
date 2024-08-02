package com.example.casestudydanang.service.category;

import com.example.casestudydanang.model.Category;
import com.example.casestudydanang.repository.category.CategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService {
    private CategoryRepository categoryRepository = new CategoryRepository();

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public void save(Category object) {

    }

    @Override
    public void update(int id, Category object) {

    }

    @Override
    public void delete(int id) {

    }
}
