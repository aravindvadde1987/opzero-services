package com.opzero.service;

import java.util.List;
import java.util.Optional;

import com.opzero.entity.Project;

public interface ProjectService {
	Project saveProject(Project project);

	Optional<Project> getProject(Long projectId);

	Project updateProject(Project project);

	List<Project> getProjects();
}
