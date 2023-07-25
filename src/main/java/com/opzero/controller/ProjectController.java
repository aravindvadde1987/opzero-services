package com.opzero.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Project;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.ProjectService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    MapperUtil mapperUtil;

    @GetMapping("/project/{id}")
    public MasterDTO getProject(@PathVariable("id") Long id) {
        if (projectService.getProject(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "project is not found for given id " + id);
        }
        return mapperUtil.getModelMapper().map(projectService.getProject(id).get(), MasterDTO.class);
    }

    @GetMapping("/projects")
    public List<MasterDTO> getProjects() {
        if (projectService.getProjects().size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "projects not found");
        }
        return projectService.getProjects().stream().map(project -> mapperUtil.getModelMapper().map(project, MasterDTO.class)).collect(Collectors.toList());
    }

    @PostMapping(value = "/project", consumes = "application/json", produces = "application/json")
    public MasterDTO saveProject(@RequestBody MasterDTO masterDTO) {
        Project project = projectService.saveProject(mapperUtil.getModelMapper().map(masterDTO, Project.class));

        return mapperUtil.getModelMapper().map(project, MasterDTO.class);
    }

    @PutMapping(value = "/project", consumes = "application/json", produces = "application/json")
    public MasterDTO updateProject(@RequestBody MasterDTO masterDTO) {
        if (projectService.getProject(masterDTO.getId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "project is not found for given id " + masterDTO.getId());
        }
        Project project = projectService.saveProject(mapperUtil.getModelMapper().map(masterDTO, Project.class));

        return mapperUtil.getModelMapper().map(project, MasterDTO.class);
    }
}
