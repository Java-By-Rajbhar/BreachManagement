package com.maggie.app.service;

import java.util.List;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.dto.BusinessAreaDto;
import com.maggie.app.dto.FranchiseResponseDto;

public interface BreachService {
	
	
	
	public List<FranchiseResponseDto> franchiseList();
	
	public List<BusinessAreaDto> franchise(long franchise);

}
