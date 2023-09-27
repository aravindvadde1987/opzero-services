
package com.opzero.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MasterDTO {

    private Long id;
    private Long parentId;
    private String name;
    private String projectName;
    private String scopeOfWork;
    private Long teamSize;
    private Long onshoreSize;
    private Long offshoreSize;
    private String engagementType;
    private String operatingModel;
    private Long fiscalYearQuarterId;
    private Long leverId;
    private Long displayOrder;

    private String displayColumnsLabels;
    private Long projectId;
    private Double actualAvgEffortPerInc;
    private Double pricedAvgEffortPerInc;
    private Double pricedAvgIncidentsPerQtr;
    private Double actualAvgIncidentsPerQtr;
    private Double totalIncidents;
    private Double totalEffort;
    private Double automatedPercent;
    private Double effortPercent;
    private Double effortSaved;
    private String solutionImplemented;
    private String solutionLink;
    private String technologiesUsed;
    private String fiscalYearQuarterDesc;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    private String createdBy;
    private String updatedBy;
    private String createdAt;
    private String updatedAt;
    private List<MasterDTO> childrens;
}
