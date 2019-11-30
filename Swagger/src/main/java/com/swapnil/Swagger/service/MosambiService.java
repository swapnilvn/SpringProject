package com.swapnil.Swagger.service;

import java.util.Map;

import com.swapnil.Swagger.dto.MosambiDto;

public interface MosambiService {

	Map<String, Object> ss(MosambiDto mosambiDto);

	Map<String, Object> show();

	Map<String, Object> cool(String color);
	

}
