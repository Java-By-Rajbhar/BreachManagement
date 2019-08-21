package com.maggie.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maggie.app.controller.AdminActionController;
import com.maggie.app.dto.ActionRequestDto;
import com.maggie.app.dto.ActionResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.exception.BreachNotFoundException;
import com.maggie.app.repository.BreachRepository;

@Service
@Transactional
public class AdminActionServiceImpl implements AdminActionService {

	@Autowired
	BreachRepository breachRepository;
	public static final Logger logger = LoggerFactory.getLogger(AdminActionController.class);

	public ActionResponseDto getBreach(ActionRequestDto actionRequestDto, Long breachId) {

		logger.info("inside getbreachById method of Admin Action Service class");
		ActionResponseDto actionResponseDto = new ActionResponseDto();
		Breach breach = breachRepository.findByBreachId(breachId);
		
		if(breach!=null)
		{
		breach.setBreachState("Closed");
		breach.setStatus("True");
		breachRepository.save(breach);
		BeanUtils.copyProperties(breach, actionResponseDto);
		logger.info("get Breach ={}",breach );
		actionResponseDto.setMessage("Breach Approved");
		
		}
		else {
			throw new BreachNotFoundException("Invalid Breach Credentials");
		}

		return actionResponseDto;
	}

}
