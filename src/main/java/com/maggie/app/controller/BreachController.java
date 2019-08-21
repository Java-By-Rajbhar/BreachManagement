package com.maggie.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.service.BreachService;


@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class BreachController {
	
	@Autowired
	BreachService breachService;
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(BreachController.class);
	
	@PostMapping("/create")
	public ResponseEntity<BreachResponseDto> create(@RequestBody BreachRequestDto breachRequestDto)
	{
		BreachResponseDto breachResponseDto=breachService.createBreach(breachRequestDto);
		return new ResponseEntity<>(breachResponseDto,HttpStatus.OK);
	}
	
	
}
