package com.maggie.app.service;

import com.maggie.app.dto.ActionRequestDto;
import com.maggie.app.dto.ActionResponseDto;

public interface AdminActionService {

	ActionResponseDto getBreach(ActionRequestDto actionRequestDto, Long breachId);

}
