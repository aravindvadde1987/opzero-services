package com.opzero.service;

import com.opzero.entity.ProjectPlanAndActual;

import java.util.List;
import java.util.Optional;

public interface ProjectPlanAndActualService {
    ProjectPlanAndActual saveProjectPlanAndActual(ProjectPlanAndActual lever);

    Optional<ProjectPlanAndActual> getProjectPlanAndActual(Long projectPlanAndActualId);

    ProjectPlanAndActual updateProjectPlanAndActual(ProjectPlanAndActual projectPlanAndActual);

    List<ProjectPlanAndActual> getProjectPlanAndActuals();
}
