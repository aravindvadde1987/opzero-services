package com.opzero.service;

import java.util.List;
import java.util.Optional;

import com.opzero.entity.Category;

public interface CategoryService {
	Category saveCategory(Category category);

	Optional<Category> getCategory(Long categoryId);
	
	Category updateCategory(Category category);

	List<Category> getCategories();
}
