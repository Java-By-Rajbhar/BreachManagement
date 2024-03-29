package com.maggie.app.dto;


import com.maggie.app.entity.Franchise;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreachResponseDto {
	private Long breachId;
	private String message;
	private int statusCode;

	private String businessName;
	private Franchise franchise;
}
