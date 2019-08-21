package com.maggie.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.repository.BreachRepository;

@Service
@Transactional

public class BreachServiceImpl implements BreachService {

	@Autowired
	private BreachRepository breachRepository;
	
	

	public BreachResponseDto createBreach(BreachRequestDto breachRequestDto) {
		
		BreachResponseDto breachResponseDto= new BreachResponseDto();
		Breach breach=new Breach();
		BeanUtils.copyProperties(breachRequestDto, breach);
		breachRepository.save(breach);
		breachResponseDto.setMessage("Breach Details successfully Submitted");
		breachResponseDto.setBreachId(breach.getBreachId());
		breachResponseDto.setStatusCode(HttpStatus.OK.value());
	
		return breachResponseDto;
	}

}
