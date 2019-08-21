package com.maggie.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreachRequestDto implements Serializable {

	private static final long serialVersionUID = 7771935079393339853L;

	private String raiseBy;
	private String riskType;
	private String franchise;
	private String businessArea;
	private String breachState;
	private Date reportedDate;
	private String breachCaategory;

}
