package com.opzero.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OfferingPortfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offeringPortfolioId;
	private String offeringPortfolioName;
	private String isActive;
	private String createdBy;
	private String updatedBy;

	public OfferingPortfolio() {
	}

	public OfferingPortfolio(Long offeringPortfolioId, String offeringPortfolioName, String isActive, String createdBy,
			String updatedBy, String createdAt, String updatedAt) {
		super();
		this.offeringPortfolioId = offeringPortfolioId;
		this.offeringPortfolioName = offeringPortfolioName;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getOfferingportfolioId() {
		return offeringPortfolioId;
	}

	public void setOfferingportfolioId(Long offeringPortfolioId) {
		this.offeringPortfolioId = offeringPortfolioId;
	}

	public String getOfferingPortfolioName() {
		return offeringPortfolioName;
	}

	public void setOfferingPortfolioName(String offeringPortfolioName) {
		this.offeringPortfolioName = offeringPortfolioName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	private String createdAt;
	private String updatedAt;
}
