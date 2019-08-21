package com.maggie.app.dto;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author Sushil
 *
 */
@Data
public class UserResponseDto {
	private Long breachId;
	private String raisedBy;
	private String riskType;
	private String franchise;
	private String businessArea;
	private String status;
	private String breachState;
	private Date reportedDate;
	private String breachCategory;

}
