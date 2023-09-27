package com.opzero.service.impl;

import com.opzero.entity.ProjectPlanAndActual;
import com.opzero.repository.ProjectPlanAndActualRepository;
import com.opzero.service.ProjectPlanAndActualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectPlanAndActualServiceImpl implements ProjectPlanAndActualService {
    @Autowired
    ProjectPlanAndActualRepository projectPlanAndActualRepository;

    @Override
    public ProjectPlanAndActual saveProjectPlanAndActual(ProjectPlanAndActual projectPlanAndActual) {
        return projectPlanAndActualRepository.save(projectPlanAndActual);
    }

    @Override
    public Optional<ProjectPlanAndActual> getProjectPlanAndActual(Long projectPlanAndActualId) {
        return projectPlanAndActualRepository.findById(projectPlanAndActualId);
    }

    @Override
    public ProjectPlanAndActual updateProjectPlanAndActual(ProjectPlanAndActual projectPlanAndActual) {
        return projectPlanAndActualRepository.save(projectPlanAndActual);
    }

    @Override
    public List<ProjectPlanAndActual> getProjectPlanAndActuals() {
        return projectPlanAndActualRepository.findAll();
    }
}