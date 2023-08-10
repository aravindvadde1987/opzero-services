package com.opzero.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.opzero.entity.Project;
import com.opzero.entity.dto.MasterDTO;

public interface ProjectService {
	Project saveProject(Project project);

	Optional<Project> getProject(Long projectId);

	Project updateProject(Project project);

	List<Project> getProjects();

	List<MasterDTO> getActiveProjects();
}
