package com.opzero.repository;

import com.opzero.entity.ProjectScope;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectScopeRepository extends JpaRepository<ProjectScope, Long> {
	List<ProjectScope> findAll();
}