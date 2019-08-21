package com.maggie.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggie.app.controller.BreachController;
import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.dto.BusinessAreaDto;
import com.maggie.app.dto.FranchiseResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.entity.BusinessArea;
import com.maggie.app.entity.Franchise;
import com.maggie.app.repository.BreachRepository;
import com.maggie.app.repository.BusinessAreaRepository;
import com.maggie.app.repository.FranchiseRepository;


@Service
public class BreahServiceImpl implements BreachService {

	
	private static final  Logger LOGGER = LoggerFactory.getLogger(BreahServiceImpl.class);
	
	@Autowired
	private FranchiseRepository franchiseRepository;
	
	@Autowired
	BusinessAreaRepository businessAreaRepository;
	
	
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
