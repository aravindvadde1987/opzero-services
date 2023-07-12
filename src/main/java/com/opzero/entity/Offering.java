package com.opzero.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

// Class
public class Offering {

	public Offering() {
	}

	public Offering(Long offeringId, Long offeringPortfolioId, String offeringName, String isActive, String createdBy,
			String updatedBy, String createdAt, String updatedAt) {
		super();
		this.offeringId = offeringId;
		this.offeringPortfolioId = offeringPortfolioId;
		this.offeringName = offeringName;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offeringId;

	public Long getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(Long offeringId) {
		this.offeringId = offeringId;
	}

	public Long getOfferingPortfolioId() {
		return offeringPortfolioId;
	}

	public void setOfferingPortfolioId(Long offeringPortfolioId) {
		this.offeringPortfolioId = offeringPortfolioId;
	}

	public String getOfferingName() {
		return offeringName;
	}

	public void setOfferingName(String offeringName) {
		this.offeringName = offeringName;
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

	private Long offeringPortfolioId;
	private String offeringName;
	private String isActive;
	private String createdBy;
	private String updatedBy;
	private String createdAt;
	private String updatedAt;
}
