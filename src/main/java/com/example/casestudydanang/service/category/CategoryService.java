package com.example.casestudydanang.service.category;

import com.example.casestudydanang.model.Category;
import com.example.casestudydanang.repository.category.CategoryRepository;

import java.util.List;

public class CategoryService {
    private CategoryRepository categoryRepository = new CategoryRepository();

    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }
}
