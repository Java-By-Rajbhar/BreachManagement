package com.maggie.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggie.app.dto.UserRequestDto;
import com.maggie.app.dto.UserResponseDto;
import com.maggie.app.entity.Breach;
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
	public List<UserResponseDto> userLogin(UserRequestDto userRequestDto) {
		// TODO Auto-generated method stub
		logger.info("inside userLogin method of UserServiceImpl class");
		/* get user object based on specific user */
		User user = userRepository.findByUserId(userRequestDto.getUserId());
        /*get riskType*/
		String riskType = user.getRole().getRoleName().equals("Low admin")?"low":user.getRole().getRoleName().equals("Medium admin")?"medium":user.getRole().getRoleName().equals("High admin")?"high":"";
		logger.info("risk type ={}",riskType);
		if (user.getUserId().equals(userRequestDto.getUserId())
				&& user.getPassword().equals(userRequestDto.getPassword())) {
			
			List<Breach> listBreach = breachRepository.findByRiskType(riskType);
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
			
		} else {
			throw new InvalidCredentialsException("User/Password is wrong !!!");
		}

	}

}
