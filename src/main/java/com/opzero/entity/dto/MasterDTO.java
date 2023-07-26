
package com.opzero.entity.dto;

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
public class MasterDTO {

	private Long id;
	private Long parentId;
	private String name;
	private String scopeOfWork;
	private Long teamSize;
	private Long onshoreSize;
	private Long offshoreSize;
	private String engagementType;
	private String operatingModel;
	private Long fiscalYearQuarterId;
	private Long leverId;
	private Long projectId;
	private double avgEffortPerInc;
	private double totalIncidents;
	private double totalEffort;
	private double automatedPercent;
	private double effortPercent;
	private double effortSaved;
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
