package com.opzero.service.impl;

import com.opzero.entity.Category;
import com.opzero.entity.Scope;
import com.opzero.repository.CategoryRepository;
import com.opzero.repository.LeverRepository;
import com.opzero.repository.ScopeRepository;
import com.opzero.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScopeServiceImpl implements ScopeService {
    @Autowired
    ScopeRepository scopeRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    LeverRepository leverRepository;

    @Override
    public Scope saveScope(Scope scope) {
        return scopeRepository.save(scope);
    }

    @Override
    public Optional<Scope> getScope(Long id) {
        Optional<Scope> scope = scopeRepository.findById(id);
        if (scope.isPresent()) {
            List<Category> categories = categoryRepository.findByScopeId(id);
            for(Category category:categories){
                category.setLevers(leverRepository.findByCategoryId(category.getId()));
            }
            scope.get().setCategories(categoryRepository.findByScopeId(id));
        }
        return scope;
    }

    @Override
    public Scope updateScope(Scope scope) {
        return scopeRepository.save(scope);
    }

    @Override
    public List<Scope> getScopes() {
        List<Scope> scopes = scopeRepository.findAll();
        return scopes;
    }
}