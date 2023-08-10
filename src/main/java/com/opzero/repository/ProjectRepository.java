package com.opzero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	List<Project> findAll();

	List<Project> findByIsActiveTrue();
}