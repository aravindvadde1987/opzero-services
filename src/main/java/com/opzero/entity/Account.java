
package com.opzero.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private Long id;
	@Column(name = "OFFERING_ID")
	private Long foreignKeyId;
	@Column(name = "ACCOUNT_NAME")
	private String name;
	private boolean isActive;
	private String createdBy;
	private String updatedBy;
	private String createdAt;
	private String updatedAt;

	public Account() {

	}

	public Account(Long id, Long foreignKeyId, String name, boolean isActive, String createdBy, String updatedBy,
			String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.foreignKeyId = foreignKeyId;
		this.name = name;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getForeignKeyId() {
		return foreignKeyId;
	}

	public void setForeignKeyId(Long foreignKeyId) {
		this.foreignKeyId = foreignKeyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
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
}
