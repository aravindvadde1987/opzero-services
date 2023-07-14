package com.opzero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Project;
import com.opzero.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@GetMapping("/project/{projectId}")
	public Project getProject(@PathVariable("projectId") Long projectId) {
		if (projectService.getProject(projectId) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "project is not found for given id " + projectId);
		}
		return projectService.getProject(projectId);
	}

	@GetMapping("/projects")
	public List<Project> getProjects() {
		if (projectService.getProjects().size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "projects not found");
		}
		return projectService.getProjects();
	}

	@PostMapping(value = "/project", consumes = "application/json", produces = "application/json")
	public Project saveProject(@RequestBody Project project) {
		if (projectService.getProject(project.getProjectId()) != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"project already exist for given id " + project.getProjectId());
		}
		return projectService.saveProject(project);
	}

	@PutMapping(value = "/project", consumes = "application/json", produces = "application/json")
	public Project updateProject(@RequestBody Project project) {
		if (projectService.getProject(project.getProjectId()) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"project is not found for given id " + project.getProjectId());
		}
		return projectService.updateProject(project);
	}
}
