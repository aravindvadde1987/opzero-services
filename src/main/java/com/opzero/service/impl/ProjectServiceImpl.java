package com.opzero.service.impl;

import com.opzero.entity.Project;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.repository.ProjectRepository;
import com.opzero.service.ProjectService;
import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    MapperUtil mapperUtil;

    @Override
    public Project saveProject(Project project) {
        setDefaultVal(project);
        return projectRepository.save(project);
    }

    private void setDefaultVal(Project project) {
        project.setEngagementType("Fixed price");
        project.setOffshoreSize(5L);
        project.setOperatingModel("US-USI-DeliveryPool");
        project.setScopeOfWork("Software Development");
        project.setTeamSize(10L);
        project.setOnshoreSize(5L);
    }

    @Override
    public Optional<Project> getProject(Long projectId) {
        return projectRepository.findById(projectId);
    }

    @Override
    public Project updateProject(Project project) {
        setDefaultVal(project);
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<MasterDTO> getActiveProjects() {
        return projectRepository.findByIsActiveTrue().stream().map(project -> mapperUtil.getModelMapper().map(project, MasterDTO.class)).collect(Collectors.toList());
    }
}
