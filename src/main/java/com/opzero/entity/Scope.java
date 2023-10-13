package com.opzero.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Scope {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCOPE_ID")
	private Long id;
	@Column(name = "SCOPE_NAME")
	private String scopeName;

	private Long displayOrder;
	private boolean isActive;
	private String createdBy;
	private String updatedBy;
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "scope")
    private List<Category> categories;
}
