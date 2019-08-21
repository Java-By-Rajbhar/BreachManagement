package com.maggie.app.service;

import java.util.List;

import com.maggie.app.dto.RiskResponseDto;

public interface RiskService {

	List<RiskResponseDto> getAllRiskProfiles(String franchise, String businessArea, String breachCategory);

}
