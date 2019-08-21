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
import com.maggie.app.entity.Breach;
import com.maggie.app.entity.BusinessArea;
import com.maggie.app.entity.Franchise;
import com.maggie.app.repository.BreachRepository;
import com.maggie.app.repository.BusinessAreaRepository;
import com.maggie.app.repository.FranchiseRepository;

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
	
	

	public BreachResponseDto2 createBreach(BreachRequestDto breachRequestDto) {
		
		BreachResponseDto2 breachResponseDto= new BreachResponseDto2();
		Breach breach=new Breach();
		BeanUtils.copyProperties(breachRequestDto, breach);
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
	
}
