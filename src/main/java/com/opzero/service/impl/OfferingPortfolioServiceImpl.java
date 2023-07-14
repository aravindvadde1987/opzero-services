package com.opzero.service.impl;

import java.util.List;

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
	public OfferingPortfolio getOfferingPortfolio(Long offeringPortfolioId) {
		return offeringPortfolioRepository.findByOfferingPortfolioId(offeringPortfolioId);
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
