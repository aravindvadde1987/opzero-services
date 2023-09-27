package com.opzero.repository;

import com.opzero.entity.ProjectPlanAndActual;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectPlanAndActualRepository extends CrudRepository<ProjectPlanAndActual, Long> {
	List<ProjectPlanAndActual> findAll();
}