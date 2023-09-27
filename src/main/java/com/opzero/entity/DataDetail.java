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
public class DataDetail {
    @Id
    @Column(name = "DATA_DETAIL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FISCAL_YEAR_QUARTER_ID")
    private Long fiscalYearQuarterId;
    private Long leverId;
    private Long projectId;
    @Column(name = "PRICED_AVG_EFFORT_PER_INC")
    private Double pricedAvgEffortPerInc;
    @Column(name = "PRICED_AVG_INCIDENTS_PER_QTR")
    private Double pricedAvgIncidentsPerQtr;
    @Column(name = "ACTUAL_AVG_EFFORT_PER_INC")
    private Double actualAvgEffortPerInc;
    @Column(name = "ACTUAL_AVG_INCIDENTS_PER_QTR")
    private Double actualAvgIncidentsPerQtr;
    @Column(name = "TOTAL_EFFORT")
    private Double totalEffort;
    @Column(name = "AUTOMATED_PERCENT")
    private Double automatedPercent;
    @Column(name = "EFFORT_PERCENT")
    private Double effortPercent;
    @Column(name = "EFFORT_SAVED")
    private Double effortSaved;
    private String createdBy;
    private String updatedBy;
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dataDetail")
    private List<SolutionDetail> solutionDetails;
}
