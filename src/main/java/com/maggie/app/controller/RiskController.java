package com.maggie.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maggie.app.dto.RiskResponseDto;
import com.maggie.app.service.RiskService;

@RestController
@RequestMapping("/api")

@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })


public class RiskController {
	
	

	@Autowired
	RiskService riskService;
	public static final Logger logger = LoggerFactory.getLogger(RiskController.class);

	@GetMapping("/riskCalculator/{franchise}/{businessArea}/{breachCategory}")

	public ResponseEntity<List<RiskResponseDto>> getAllRiskProfiles(@PathVariable String franchise, @PathVariable String businessArea,@PathVariable String breachCategory) 
	
	{
		logger.info("inside getAllMerchants method of merchant controller class");

		List<RiskResponseDto> riskResponseDto = riskService.getAllRiskProfiles(franchise,businessArea,breachCategory);
		return new ResponseEntity<>(riskResponseDto,HttpStatus.OK);

	}
}
