package com.opzero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opzero.entity.Project;
import com.opzero.repository.ProjectRepository;
import com.opzero.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project getProject(Long projectId) {
		return projectRepository.findByProjectId(projectId);
	}

	@Override
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}
}
