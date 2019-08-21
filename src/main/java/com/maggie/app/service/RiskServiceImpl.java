package com.maggie.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maggie.app.controller.RiskController;
import com.maggie.app.dto.RiskResponseDto;
import com.maggie.app.entity.Risk;
import com.maggie.app.repository.RiskRepository;

@Service
@Transactional
public class RiskServiceImpl implements RiskService {

	@Autowired
	RiskRepository riskRepository;
	public static final Logger logger = LoggerFactory.getLogger(RiskController.class);

	public List<RiskResponseDto> getAllRiskProfiles(String franchise, String businessArea, String breachCategory) {
		logger.info("inside getListOfMerchants method of merchant Service class");
		
		List<RiskResponseDto> riskResponseDto = new ArrayList<>();
		
		List<Risk> riskList = riskRepository.findAll();
		
		for (Risk risk2 : riskList) {
			RiskResponseDto riskResponseDto2 = new RiskResponseDto();
			if (risk2.getFranchise().equals(franchise) && risk2.getBusinessArea().equals(businessArea)
					&& risk2.getBreachCategory().equals(breachCategory)) {
				riskResponseDto2.setRiskType(risk2.getRiskProfile());
				riskResponseDto.add(riskResponseDto2);
			}
			
			else {
				riskResponseDto2.setRiskType("Low");
				riskResponseDto.add(riskResponseDto2);
			}
			}
		    return riskResponseDto;
	}
}
