package com.swap.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swap.demo.dto.MasaDto;
import com.swap.demo.service.MasaService;

/**
 * @author NAGOTHANEKAR
 *
 */
@RestController
public class MasaController {
	
	@Autowired
	private MasaService masaService;
	
	@PostMapping("/Save")
	public Map<String, Object>Save(@RequestBody MasaDto masaDto)
	{
		return masaService.krSave(masaDto);
	}

	@GetMapping("/getData")
	public Map<String, Object>getData()
	{
		return masaService.getData();
	}
	
	@GetMapping("/getById")
	public Map<String, Object>getById(@RequestParam ("id") Long id, Boolean active)
	{
		return masaService.getById(id, active);
	}
	
	@DeleteMapping("/deleteById")
	public Long deleteById(@RequestParam ("id") Long id)
	{
		return masaService.deleteById(id);
	}
	
	@PutMapping("/activeInactive")
	public Map<String, Object>activeInactive(@RequestParam("id")Long id, Boolean active)
	{
		return masaService.activeInactive(id, active);
	}
	
}
