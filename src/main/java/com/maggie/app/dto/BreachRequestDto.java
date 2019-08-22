package com.maggie.app.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreachRequestDto {

	private String raiseBy;
	private String franchise;
	private String businessArea;
	private Date reportedDate;
	private String breachCategory;
	private String riskType;
	
}

	