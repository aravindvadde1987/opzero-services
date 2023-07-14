package com.opzero.service;

import java.util.List;

import com.opzero.entity.Project;

public interface ProjectService {
	Project saveProject(Project project);

	Project getProject(Long projectId);

	Project updateProject(Project project);

	List<Project> getProjects();
}
