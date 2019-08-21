package com.maggie.app.service;

import java.util.List;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.dto.UserResponseDto;
import com.maggie.app.entity.Breach;

public interface BreachService {
	
	public BreachResponseDto create(BreachRequestDto breachRequestDto);
	
	public List<Breach> getBreachByStatus(String status);
	
	public List<UserResponseDto> getListBreachBasedOnRoleId(Long roleId);

}
