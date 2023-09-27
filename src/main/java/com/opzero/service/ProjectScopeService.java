package com.opzero.service;

import com.opzero.entity.ProjectScope;
import com.opzero.entity.dto.MasterDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectScopeService {
	ProjectScope saveProjectScope(ProjectScope projectScope);

	Optional<ProjectScope> getProjectScope(Long projectScopeId);

	ProjectScope updateProjectScope(ProjectScope projectScope);

	List<ProjectScope> getProjectScopes();

	List<ProjectScope> getActiveProjectScopes();
}
