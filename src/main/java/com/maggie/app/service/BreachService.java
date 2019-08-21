package com.maggie.app.service;

import java.util.List;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto2;
import com.maggie.app.dto.BusinessAreaDto;
import com.maggie.app.dto.FranchiseResponseDto;
import com.maggie.app.dto.UserResponseDto;
import com.maggie.app.entity.Breach;

public interface BreachService {

	public BreachResponseDto2 createBreach(BreachRequestDto breachRequestDto);

	public List<FranchiseResponseDto> franchiseList();

	public List<BusinessAreaDto> franchise(long franchise);
	public List<Breach> getBreachByStatus(String status);
	
	public List<UserResponseDto> getListBreachBasedOnRoleId(Long roleId);

}
