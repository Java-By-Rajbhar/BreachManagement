package com.maggie.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.dto.UserResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.entity.Role;
import com.maggie.app.repository.BreachRepository;
import com.maggie.app.repository.RoleRepository;

@Service
public class BreahServiceImpl implements BreachService {
	
private static final Logger logger = LoggerFactory.getLogger(BreahServiceImpl.class);
	@Autowired
	private BreachRepository breachRepository;
	@Autowired
	RoleRepository roleRepository;
	@Override
	public BreachResponseDto create(BreachRequestDto breachRequestDto) {
		
		Breach breach=new Breach();
		
		return null;
	}

	@Override
	/**
	 * This method is use to get list of breach based on status like opened or closed
	 * @param status
	 * @return List<Breach>
	 */
	public List<Breach> getBreachByStatus(String status) {
		
		logger.info("inside getBreachByStatus method of BreahServiceImpl class");
		
		return breachRepository.findByStatus(status);
	}

	@Override
	/**
	 * This method is use to get list of breaches based on role id
	 * @param roleId
	 * @return List<UserResponseDto>
	 */
	public List<UserResponseDto> getListBreachBasedOnRoleId(Long roleId) {
		// TODO Auto-generated method stub
		Role role =  roleRepository.findByRoleId(roleId);
		
		logger.info("inside userLogin method of UserServiceImpl class");
        /*get riskType*/
		String riskType = role.getRoleName().equals("Low admin")?"low":role.getRoleName().equals("Medium admin")?"medium":role.getRoleName().equals("High admin")?"high":"super";
		List<Breach> listBreach;
		logger.info("risk type ={}",riskType);

			if(riskType.equals("super") && roleId!=5 )
			{
				listBreach = breachRepository.findAll();
			}
			else
			{
				 listBreach = breachRepository.findByRiskType(riskType);
			}
			
			/* create object of UserResponseDto and prepare list of it */
			List<UserResponseDto> listResponse = new ArrayList<>();
			
			for (Breach breach : listBreach) {
				UserResponseDto responseDto = new UserResponseDto();
				responseDto.setBreachId(breach.getBreachId());
				responseDto.setBreachCategory(breach.getBreachCategory());
				responseDto.setBreachState(breach.getBreachState());
				responseDto.setBusinessArea(breach.getBusinessArea());
				responseDto.setFranchise(breach.getFranchise());
				responseDto.setRaisedBy(breach.getRaisedBy());
				responseDto.setReportedDate(breach.getReportedDate());
				responseDto.setRiskType(breach.getRiskType());
				responseDto.setStatus(breach.getStatus());
				
				listResponse.add(responseDto);
				
			}

			return listResponse;
			
		

	}

}
