package com.opzero.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Long id;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	private Long displayOrder;
	private boolean isActive;
	private String createdBy;
	private String updatedBy;
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	@OneToMany
	@JoinColumn(name = "LEVER_ID")
    private List<Lever> levers;
}
