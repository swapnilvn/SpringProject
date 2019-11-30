package com.swapnil.curd.presentation.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.swapnil.curd.business.dto.GetSwapnilDto;
import com.swapnil.curd.business.service.SwapnilService;

@RestController
public class SwapnilController {

	@Autowired
	SwapnilService swapnilService;

	@PostMapping("/save")
	public Map<String, Object> SaveData(@RequestBody GetSwapnilDto getSwapnilDto) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		map = swapnilService.saveData(getSwapnilDto);
		return map;
	}

	@PostMapping("/getData")
	public Map<String, Object> getData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map = swapnilService.getData();
		return map;
	}

	@PostMapping("/ShowOnConsole")
	public Map<String, Object> show() throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> map = new HashMap<>();
		map = swapnilService.show();
		return map;
	}
	
	@PostMapping("/nn")
	public Map<String, Object> dd() throws JsonParseException, JsonMappingException, IOException {
		
		return swapnilService.nn();
	}
}
