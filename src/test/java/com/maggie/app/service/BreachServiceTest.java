package com.maggie.app.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.repository.BreachRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BreachServiceTest {

	@Autowired
	BreachServiceImpl breachServiceImpl;
	@Autowired
	BreachService breachService;
	@MockBean
	BreachRepository breachRepository;

	BreachRequestDto breachRequestDto = null;
	BreachResponseDto breachResponseDto = null;
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

		breachResponseDto = new BreachResponseDto();
		breachResponseDto.setMessage("Breach Details successfully Submitted");

		Mockito.when(breachRepository.save(Mockito.any())).thenReturn(breach);

		assertEquals(breachResponseDto.getMessage(), breachService.createBreach(breachRequestDto).getMessage());

	}
}