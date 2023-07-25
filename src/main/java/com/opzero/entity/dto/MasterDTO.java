
package com.opzero.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MasterDTO {

	private Long id;
	private Long foreignKeyId;
	private String name;
	private boolean isActive;
	private String createdBy;
	private String updatedBy;
	private String createdAt;
	private String updatedAt;

	private List<MasterDTO> childrens;

}
