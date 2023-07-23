package com.opzero.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Category;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/category/{id}")
	public MasterDTO getCategory(@PathVariable("id") Long id) {
		if (!categoryService.getCategory(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category is not found for given id " + id);
		}
		return modelMapper.map(categoryService.getCategory(id).get(), MasterDTO.class);
	}

	@GetMapping("/categories")
	public List<MasterDTO> getCategorys() {
		if (categoryService.getCategories().size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categories not found");
		}
		return categoryService.getCategories().stream().map(category -> modelMapper.map(category, MasterDTO.class))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/category", consumes = "application/json", produces = "application/json")
	public MasterDTO saveCategory(@RequestBody MasterDTO masterDTO) {
		Category category = categoryService.saveCategory(modelMapper.map(masterDTO, Category.class));
		return modelMapper.map(category, MasterDTO.class);
	}

	@PutMapping(value = "/category", consumes = "application/json", produces = "application/json")
	public MasterDTO updateCategory(@RequestBody MasterDTO masterDTO) {
		if (!categoryService.getCategory(masterDTO.getId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Category is not found for given id " + masterDTO.getId());
		}
		Category category = categoryService.saveCategory(modelMapper.map(masterDTO, Category.class));
		return modelMapper.map(category, MasterDTO.class);
	}
}
