package com.maggie.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto2;
import com.maggie.app.dto.BusinessAreaDto;
import com.maggie.app.dto.FranchiseResponseDto;
import com.maggie.app.dto.UserResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.entity.BusinessArea;
import com.maggie.app.entity.Franchise;
import com.maggie.app.entity.Role;
import com.maggie.app.repository.BreachRepository;
import com.maggie.app.repository.BusinessAreaRepository;
import com.maggie.app.repository.FranchiseRepository;
import com.maggie.app.repository.RoleRepository;

@Service
@Transactional

public class BreachServiceImpl implements BreachService {

private static final  Logger LOGGER = LoggerFactory.getLogger(BreachServiceImpl.class);
	
	@Autowired
	private FranchiseRepository franchiseRepository;
	
	@Autowired
	BusinessAreaRepository businessAreaRepository;
	
	@Autowired
	private BreachRepository breachRepository;
	
	
	@Autowired
	RoleRepository roleRepository;
	
	

	public BreachResponseDto2 createBreach(BreachRequestDto breachRequestDto) {
		
		BreachResponseDto2 breachResponseDto= new BreachResponseDto2();
		Breach breach=new Breach();
		BeanUtils.copyProperties(breachRequestDto, breach);
		breach.setStatus("PENDING");
		breach.setBreachState("OPEN");
		breachRepository.save(breach);
		breachResponseDto.setMessage("Breach Details successfully Submitted");
		breachResponseDto.setBreachId(breach.getBreachId());
		breachResponseDto.setStatusCode(HttpStatus.OK.value());
	
		return breachResponseDto;
	}


	
	
	/*method to show all franchise
	 * @Param 
	 * @return List of franchise
	 */

	@Override
	public List<FranchiseResponseDto> franchiseList() {
		LOGGER.info("franchiseList in");
		
		List<FranchiseResponseDto> listFranchise=new ArrayList<>();
		List<Franchise> frenshise=franchiseRepository.findAll();
		
		
		frenshise.stream().forEach(f->{
			FranchiseResponseDto franchiseResponseDto=new FranchiseResponseDto();
			BeanUtils.copyProperties(f,franchiseResponseDto);
			listFranchise.add(franchiseResponseDto);
		});
		
		
		
		return listFranchise;
	}


	/*method to show all franchise
	 * @Param long franchiseid
	 * @return List businessArea 
	 */
	@Override
	public List<BusinessAreaDto> franchise(long franchiseId) {

		LOGGER.info("franchise in");
		List<BusinessAreaDto> biusinessResponseDto=new ArrayList<>();
		List<BusinessArea> BusinessAreaOptional=businessAreaRepository.findByFranchiseFranchiseId(franchiseId);
		
		BusinessAreaOptional.stream().forEach(a->{
			BusinessAreaDto businessAreaDto =new BusinessAreaDto();
			BeanUtils.copyProperties(a, businessAreaDto);
			biusinessResponseDto.add(businessAreaDto);
		});
		
        return biusinessResponseDto;
	}
	@Override
	/**
	 * This method is use to get list of breach based on status like opened or closed
	 * @param status
	 * @return List<Breach>
	 */
	public List<Breach> getBreachByStatus(String status) {
		
		LOGGER.info("inside getBreachByStatus method of BreahServiceImpl class");
		
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
		
		LOGGER.info("inside userLogin method of UserServiceImpl class");
        /*get riskType*/
		String riskType = role.getRoleName().equals("Low admin")?"low":role.getRoleName().equals("Medium admin")?"medium":role.getRoleName().equals("High admin")?"high":"super";
		List<Breach> listBreach;
		LOGGER.info("risk type ={}",riskType);

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
