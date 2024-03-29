package com.maggie.app.controller;

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

import com.maggie.app.dto.ActionResponseDto;
import com.maggie.app.service.AdminActionService;

@RestController
@RequestMapping("/api")

@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })

public class AdminActionController {

	@Autowired
	AdminActionService adminActionService;

	public static final Logger logger = LoggerFactory.getLogger(AdminActionController.class);

	@GetMapping("/action/{breachId}")

	public ResponseEntity<ActionResponseDto> getBeach(@PathVariable Long breachId)

	{
		logger.info("inside getAllRiskProfiles method of Risk controller class");
		ActionResponseDto actionResponseDto = adminActionService.getBreach(breachId);
		return new ResponseEntity<>(actionResponseDto, HttpStatus.OK);
	}
}
