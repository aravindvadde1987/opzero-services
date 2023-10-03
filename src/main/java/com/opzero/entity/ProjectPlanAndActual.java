package com.opzero.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectPlanAndActual {
    @Id
    @Column(name = "PROJECT_PLAN_AND_ACTUAL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long projectId;
    @Column(name = "PROJECT_SCOPE_ID")
    private Long projectScopeId;
    @Column(name = "YEAR")
    private String year;
    private Double plannedFte;
    private Double actualFte;
    @Column(name = "ACTUAL_AVG_INCIDENTS_PER_QTR")
    private Double actualAvgIncidentsPerQtr;
    @Column(name = "DISTRIBUTION_PERCENT")
    private Double distributionPercent;
    private String createdBy;
    private String updatedBy;
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
