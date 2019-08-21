package com.maggie.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maggie.app.dto.UserRequestDto;
import com.maggie.app.dto.UserResponseDto;
import com.maggie.app.service.UserService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	UserService userService;
	/**
	 * This method is use to call userLogin 
	 * @param userRequestDto
	 * @return ResponseEntity<List<UserResponseDto>>
	 */
	@PostMapping("/login")
	public ResponseEntity<List<UserResponseDto>> userLogin(@RequestBody UserRequestDto userRequestDto)
	{
		logger.info("inside userLogin method LoginController class");
		List<UserResponseDto> loginResponse = userService.userLogin(userRequestDto);
		return new ResponseEntity<List<UserResponseDto>>(loginResponse, HttpStatus.OK);
	}
}
