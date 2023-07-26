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
public class DataDetail {
    @Id
    @Column(name = "DATA_DETAIL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FISCAL_YEAR_QUARTER_ID")
    private Long fiscalYearQuarterId;
    private Long leverId;
    private Long projectId;
    @Column(name = "AVG_EFFORT_PER_INC")
    private double avgEffortPerInc;
    @Column(name = "TOTAL_INCIDENTS")
    private double totalIncidents;
    @Column(name = "TOTAL_EFFORT")
    private double totalEffort;
    @Column(name = "AUTOMATED_PERCENT")
    private double automatedPercent;
    @Column(name = "EFFORT_PERCENT")
    private double effortPercent;
    @Column(name = "EFFORT_SAVED")
    private double effortSaved;
    private String createdBy;
    private String updatedBy;
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
