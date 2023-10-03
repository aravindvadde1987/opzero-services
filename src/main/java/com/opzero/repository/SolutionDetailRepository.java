package com.opzero.repository;

import com.opzero.entity.SolutionDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SolutionDetailRepository extends CrudRepository<SolutionDetail, Long> {
	List<SolutionDetail> findAll();
}