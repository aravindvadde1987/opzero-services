package com.opzero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();

    List<Category> findByScopeId(Long id);
}