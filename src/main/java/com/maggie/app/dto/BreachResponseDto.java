package com.maggie.app.dto;

import com.maggie.app.entity.Franchise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreachResponseDto {

	private String businessName;
	private Franchise franchise;
}
