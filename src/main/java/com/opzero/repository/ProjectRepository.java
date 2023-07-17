package com.opzero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
}