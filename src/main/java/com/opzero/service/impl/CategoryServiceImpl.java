package com.opzero.service.impl;

import java.util.List;
import java.util.Optional;

import com.opzero.entity.Lever;
import com.opzero.repository.LeverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opzero.entity.Category;
import com.opzero.repository.CategoryRepository;
import com.opzero.service.CategoryService;
import org.springframework.util.ObjectUtils;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    LeverRepository leverRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            category.get().setLevers(leverRepository.findByCategoryId(id));
        }
        return category;
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories != null && !categories.isEmpty()) {
            for (Category category : categories) {
                category.setLevers(leverRepository.findByCategoryId(category.getId()));
            }
        }
        return categories;
    }
}
