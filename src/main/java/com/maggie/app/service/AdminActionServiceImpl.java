package com.maggie.app.service;

import org.apache.commons.httpclient.HttpStatus;
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

	public ActionResponseDto getBreach(Long breachId) {

		logger.info("inside getbreachById method of Admin Action Service class");
		ActionResponseDto actionResponseDto = new ActionResponseDto();
		Breach breach = breachRepository.findByBreachId(breachId);

		if (breach != null) {
			if(breach.getBreachState().equalsIgnoreCase("opened")||breach.getBreachState().equalsIgnoreCase("Reopened"))
			{
			breach.setBreachState("Closed");
			}
			else if (breach.getBreachState().equalsIgnoreCase("Closed"))
			{
				breach.setBreachState("Reopened");	
			}
			breach.setStatus("True");
			breachRepository.save(breach);
			BeanUtils.copyProperties(breach, actionResponseDto);
			logger.info("get Breach ={}", breach);
			actionResponseDto.setMessage("Breach State Updated");
			actionResponseDto.setStatusCode(HttpStatus.SC_OK);

		} else {
			throw new BreachNotFoundException("Invalid Breach Credentials");
		}

		return actionResponseDto;
	}

}
