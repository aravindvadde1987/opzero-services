package com.opzero.service.impl;

import com.opzero.entity.ProjectScope;
import com.opzero.repository.ProjectScopeRepository;
import com.opzero.service.ProjectScopeService;
import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectScopeServiceImpl implements ProjectScopeService {
    @Autowired
    ProjectScopeRepository projectScopeRepository;

    @Autowired
    MapperUtil mapperUtil;

    @Override
    public ProjectScope saveProjectScope(ProjectScope projectScope) {
        return projectScopeRepository.save(projectScope);
    }

    @Override
    public Optional<ProjectScope> getProjectScope(Long projectScopeId) {
        return projectScopeRepository.findById(projectScopeId);
    }

    @Override
    public ProjectScope updateProjectScope(ProjectScope projectScope) {
        return projectScopeRepository.save(projectScope);
    }

    @Override
    public List<ProjectScope> getProjectScopes() {
        return projectScopeRepository.findAll();
    }

    @Override
    public List<ProjectScope> getActiveProjectScopes() {
        return projectScopeRepository.findAll();
    }
}
