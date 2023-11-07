package com.opzero.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.opzero.entity.Lever;
import com.opzero.service.ScopeService;
import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Category;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.CategoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ScopeService scopeService;
    @Autowired
    MapperUtil mapperUtil;


    @GetMapping("/category/{id}")
    public MasterDTO getCategory(@PathVariable("id") Long id) {
        if (!categoryService.getCategory(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category is not found for given id " + id);
        }
        return mapperUtil.getModelMapper().map(categoryService.getCategory(id).get(), MasterDTO.class);
    }

    @GetMapping("/categories")
    public List<MasterDTO> getCategorys() {
        return categoryService.getCategories().stream().map(category -> mapperUtil.getModelMapper().map(category, MasterDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/activeCategories")
    public List<MasterDTO> getActiveCategorys() {
        List<MasterDTO> categories = categoryService.getCategories().stream().map(category -> mapperUtil.getModelMapper().map(category, MasterDTO.class)).filter(masterDto -> masterDto.isActive()).collect(Collectors.toList());

        for (MasterDTO category : categories) {
            List<MasterDTO> childrens = category.getChildrens().stream().filter(masterDto -> masterDto.isActive()).collect(Collectors.toList());
            category.setChildrens(childrens);
        }
        return categories;
    }

    @PostMapping(value = "/category", consumes = "application/json", produces = "application/json")
    public MasterDTO saveCategory(@RequestBody MasterDTO masterDTO) {
//Default value until we start using / implementing
        masterDTO.setProjectScopeId(1L);
        Category input = mapperUtil.getModelMapper().map(masterDTO, Category.class);
        input.setScope(scopeService.getScope(masterDTO.getParentId()).get());
        Category category = categoryService.saveCategory(input);
        return mapperUtil.getModelMapper().map(category, MasterDTO.class);
    }

    @PutMapping(value = "/category", consumes = "application/json", produces = "application/json")
    public MasterDTO updateCategory(@RequestBody MasterDTO masterDTO) {
        //Default value until we start using / implementing
        masterDTO.setProjectScopeId(1L);
        if (!categoryService.getCategory(masterDTO.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category is not found for given id " + masterDTO.getId());
        }
        Category input = mapperUtil.getModelMapper().map(masterDTO, Category.class);
        input.setScope(scopeService.getScope(masterDTO.getParentId()).get());
        Category category = categoryService.saveCategory(input);
        return mapperUtil.getModelMapper().map(category, MasterDTO.class);
    }
}
