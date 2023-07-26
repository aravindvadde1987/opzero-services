package com.opzero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.Lever;

public interface LeverRepository extends CrudRepository<Lever, Long> {
	List<Lever> findAll();
	List<Lever> findByCategoryId(Long categoryId);
}