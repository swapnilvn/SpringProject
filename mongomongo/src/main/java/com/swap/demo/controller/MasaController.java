package com.swap.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swap.demo.dto.MasaDto;
import com.swap.demo.service.MasaService;

@RestController
public class MasaController {
	
	@Autowired
	private MasaService masaService;
	
	@PostMapping("/krSave")
	public Map<String, Object>krSave(@RequestBody MasaDto masaDto)
	{
		return masaService.krSave(masaDto);
	}

	@GetMapping("/getData")
	public Map<String, Object>getData()
	{
		return masaService.getData();
	}
	
}
