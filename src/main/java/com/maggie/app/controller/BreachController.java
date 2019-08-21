package com.maggie.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;


@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class BreachController {
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(BreachController.class);

	@PostMapping("/create")
	public ResponseEntity<BreachResponseDto> create(@RequestBody BreachRequestDto breachRequestDto)
	{
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
