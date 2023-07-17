package com.opzero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opzero.entity.OfferingPortfolio;
import com.opzero.repository.OfferingPortfolioRepository;
import com.opzero.service.OfferingPortfolioService;

@Service
public class OfferingPortfolioServiceImpl implements OfferingPortfolioService {
	@Autowired
	OfferingPortfolioRepository offeringPortfolioRepository;

	@Override
	public OfferingPortfolio saveOfferingPortfolio(OfferingPortfolio offeringPortfolio) {
		return offeringPortfolioRepository.save(offeringPortfolio);
	}

	@Override
	public Optional<OfferingPortfolio> getOfferingPortfolio(Long id) {
		return offeringPortfolioRepository.findById(id);
	}

	@Override
	public OfferingPortfolio updateOfferingPortfolio(OfferingPortfolio offeringPortfolio) {
		return offeringPortfolioRepository.save(offeringPortfolio);
	}

	@Override
	public List<OfferingPortfolio> getOfferingPortfolios() {
		return offeringPortfolioRepository.findAll();
	}
}
