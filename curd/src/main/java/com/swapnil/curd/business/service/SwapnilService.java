package com.swapnil.curd.business.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.swapnil.curd.business.dto.GetSwapnilDto;

public interface SwapnilService {

	Map<String, Object> saveData(GetSwapnilDto getSwapnilDto) throws ParseException;

	Map<String, Object> getData();

	Map<String, Object> getAllData();

	Map<String, Object> show() throws JsonParseException, JsonMappingException, IOException;

	Map<String, Object> nn() throws JsonParseException, JsonMappingException, IOException;

}
