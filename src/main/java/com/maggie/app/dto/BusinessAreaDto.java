package com.maggie.app.dto;

import java.io.Serializable;

import com.maggie.app.entity.Franchise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessAreaDto implements Serializable {

	private static final long serialVersionUID = 7731935079293339854L;
	
	private Long businessId;
	private String businessName;
	private Franchise franchise;
}
