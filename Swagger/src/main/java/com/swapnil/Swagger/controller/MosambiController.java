package com.swapnil.Swagger.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swapnil.Swagger.dto.MosambiDto;
import com.swapnil.Swagger.service.MosambiService;

@RestController
public class MosambiController {

	@Autowired
	private MosambiService mosambiService;
	
	@PostMapping("/ghe")
	public Map<String, Object>method(@RequestBody MosambiDto mosambiDto)
	{
		Map<String, Object>map = new HashMap<String, Object>();
		map = mosambiService.ss(mosambiDto);
		return map;
	}
	
	@PostMapping("/get")
	public Map<String, Object>show()
	{
		Map<String, Object>map = new HashMap<String, Object>();
		map = mosambiService.show();
		return map;
	}
	
	@PostMapping("/ByColor")
	public Map<String, Object>coo(@RequestParam("color") String color)
	{
		Map<String, Object>map = new HashMap<String, Object>();
		map = mosambiService.cool(color);
		return map;
	}
}
