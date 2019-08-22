package com.maggie.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto2;
import com.maggie.app.dto.FranchiseResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.entity.BusinessArea;
import com.maggie.app.entity.Franchise;
import com.maggie.app.repository.BreachRepository;
import com.maggie.app.repository.FranchiseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BreachServiceTest {

	@Autowired
	BreachServiceImpl breachServiceImpl;
	@Autowired
	BreachService breachService;
	@MockBean
	BreachRepository breachRepository;
	@Mock
	FranchiseRepository franchiseRepository;
	
	
	BreachRequestDto breachRequestDto = null;
	BreachResponseDto2 breachResponseDto = null;
	Breach breach = null;

	@Test
	public void createBreachTest() {
		breachRequestDto = new BreachRequestDto();
		breachRequestDto.setBreachCategory("LossOF Pin");
		breachRequestDto.setBreachState("Opened");
		breachRequestDto.setBusinessArea("Customer Experience");
		breachRequestDto.setFranchise("private Banking");

		breach = new Breach();
		breach.setBreachId(1L);

		breachResponseDto = new BreachResponseDto2();
		breachResponseDto.setMessage("Breach Details successfully Submitted");

		Mockito.when(breachRepository.save(Mockito.any())).thenReturn(breach);

		assertEquals(breachResponseDto.getMessage(), breachService.createBreach(breachRequestDto).getMessage());

	}
	
	@Test
	public void franchiseListTest()
	{
		Franchise franchise=new Franchise(); 
		franchise.setFranchiseId(1L);
		franchise.setFranchiseName("Private Banking");
	
		BusinessArea businessArea=new BusinessArea();
		businessArea.setBusinessId(1L);
		businessArea.setBusinessName("Business Loan");
		businessArea.setFranchise(franchise);
		List<BusinessArea> listBusines=new ArrayList<>();
		listBusines.add(businessArea);
		franchise.setBusinessArea(listBusines);
		List<Franchise> listFranchise=new ArrayList<>();
		when(franchiseRepository.findAll()).thenReturn(listFranchise);
		List<FranchiseResponseDto> actual= breachServiceImpl.franchiseList();
		assertEquals("Private Banking", actual.get(0).getFranchiseName());
	}
}