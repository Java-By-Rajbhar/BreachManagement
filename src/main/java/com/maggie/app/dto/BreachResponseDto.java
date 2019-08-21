package com.maggie.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreachResponseDto {
	private Long breachId;
	private String message;
	private int statusCode;

}
