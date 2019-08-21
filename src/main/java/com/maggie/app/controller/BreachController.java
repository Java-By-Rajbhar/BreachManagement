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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.dto.UserResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.service.BreachService;


@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class BreachController {
	
	private static final  Logger logger = LoggerFactory.getLogger(BreachController.class);
    @Autowired
    BreachService breachService;
    
	@PostMapping("/create")
	public ResponseEntity<BreachResponseDto> create(@RequestBody BreachRequestDto breachRequestDto)
	{
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/viewBreach/{status}")
	public ResponseEntity<List<Breach>> getBreachByStatus(@PathVariable String status)
	{
		logger.info("inside getBreachByStatus method of BreachController class");
		List<Breach> listBreach = breachService.getBreachByStatus(status);
		return new ResponseEntity<List<Breach>>(listBreach, HttpStatus.OK);
	}
	
	@GetMapping("/breaches/{roleId}")
	public ResponseEntity<List<UserResponseDto>> getListBreachBasedOnRoleid(@PathVariable Long roleId)
	{
		logger.info("inside getListBreachBasedOnRoleid method of BreachController class");
		List<UserResponseDto> listResponse = breachService.getListBreachBasedOnRoleId(roleId);
		return new ResponseEntity<List<UserResponseDto>>(listResponse, HttpStatus.OK);
	}
	
}
