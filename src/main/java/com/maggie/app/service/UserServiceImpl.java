package com.maggie.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.maggie.app.dto.UserDetailDto;
import com.maggie.app.dto.UserRequestDto;
import com.maggie.app.dto.UserResponseDto;
import com.maggie.app.entity.User;
import com.maggie.app.exception.InvalidCredentialsException;
import com.maggie.app.repository.BreachRepository;
import com.maggie.app.repository.UserRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	BreachRepository breachRepository;

	/**
	 * This method is use to login
	 * 
	 * @param userRequestDto, userId,password
	 * @return List<UserResponseDto>
	 * @exception InvalidCredentialsException
	 */
	@Override
	public UserDetailDto userLogin(UserRequestDto userRequestDto) {
		// TODO Auto-generated method stub
		logger.info("inside userLogin method of UserServiceImpl class");
		/* get user object based on specific user */
		User user = userRepository.findByUserId(userRequestDto.getUserId());
		if (user.getUserId().equals(userRequestDto.getUserId())
				&& user.getPassword().equals(userRequestDto.getPassword())) {
			UserDetailDto detailDto = new UserDetailDto();
			
			detailDto.setRoleId(user.getRole().getRoleId());
			detailDto.setStatusCode(HttpStatus.OK.value());
			detailDto.setMessage("User has  been logged in successfully");
			
			return detailDto;
			
		} else {
			throw new InvalidCredentialsException("User/Password is wrong !!!");
		}

	}

}
