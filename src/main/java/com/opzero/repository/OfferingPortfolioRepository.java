package com.opzero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.OfferingPortfolio;

public interface OfferingPortfolioRepository extends CrudRepository<OfferingPortfolio, Long> {
	List<OfferingPortfolio> findAll();
}