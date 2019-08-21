package com.maggie.app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maggie.app.dto.BreachRequestDto;
import com.maggie.app.dto.BreachResponseDto2;
import com.maggie.app.entity.Breach;
import com.maggie.app.service.BreachService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BreachController.class)
public class BreachControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	BreachService breachService;

	BreachResponseDto2 breachResponseDto = null;
	BreachRequestDto breachRequestDto = null;
	Breach breach = null;

	@Test
	public void createTest() throws Exception {
		breachRequestDto = new BreachRequestDto();
		breachRequestDto.setBreachCategory("LossOF Pin");
		breachRequestDto.setBreachState("Opened");
		breachRequestDto.setBusinessArea("Customer Experience");
		breachRequestDto.setFranchise("private Banking");

		breach = new Breach();
		breach.setBreachId(1L);

		breachResponseDto = new BreachResponseDto2();
		breachResponseDto.setMessage("Breach Is successfully registered.....");

		Mockito.when(breachService.createBreach(breachRequestDto)).thenReturn(breachResponseDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/create").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(breachResponseDto))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
