package com.maggie.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.repository.BreachRepository;

public class BreahServiceImpl implements BreachService {

	@Autowired
	private BreachRepository breachRepository;
	
	@Override
	public BreachResponseDto create(BreachRequestDto breachRequestDto) {
		
		Breach breach=new Breach();
		
		return null;
	}

}
