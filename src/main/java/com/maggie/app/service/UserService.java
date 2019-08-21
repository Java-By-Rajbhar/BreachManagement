package com.maggie.app.service;

import java.util.List;

import com.maggie.app.dto.UserRequestDto;
import com.maggie.app.dto.UserResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface UserService {
	
	public List<UserResponseDto> userLogin(UserRequestDto userRequestDto);

}
