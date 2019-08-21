package com.maggie.app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maggie.app.dto.ActionRequestDto;
import com.maggie.app.entity.Breach;
import com.maggie.app.service.AdminActionServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminActionControllerTest {

	@Mock
	AdminActionServiceImpl adminActionServiceImpl;
	private MockMvc mockMvc;

	@InjectMocks
	AdminActionController adminActionController;

	ActionRequestDto actionRequestDto;
	
	



	@Test
	public void getBreachTest() throws Exception {
		actionRequestDto = new ActionRequestDto();
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(adminActionController).build();
		
		Breach breach= new Breach();
		breach.setBreachId(1L);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/action/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(actionRequestDto))).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {

		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
