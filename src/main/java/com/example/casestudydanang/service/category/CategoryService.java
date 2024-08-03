package com.example.casestudydanang.service.category;

import com.example.casestudydanang.model.Category;
import com.example.casestudydanang.repository.category.CategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService {
    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(int id, Category object) {
        categoryRepository.update(id, object);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }
    public boolean isDelete(int id) {
        return categoryRepository.isDelete(id);
    }

}
