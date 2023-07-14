package com.opzero.service;

import java.util.List;

import com.opzero.entity.OfferingPortfolio;

public interface OfferingPortfolioService {
	OfferingPortfolio saveOfferingPortfolio(OfferingPortfolio offeringPortfolio);

	OfferingPortfolio getOfferingPortfolio(Long offeringPortfolioId);

	OfferingPortfolio updateOfferingPortfolio(OfferingPortfolio offeringPortfolio);
	
	List<OfferingPortfolio> getOfferingPortfolios();
}
