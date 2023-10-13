package com.opzero.repository;

import com.opzero.entity.Scope;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScopeRepository extends CrudRepository<Scope, Long> {
    List<Scope> findAll();
}