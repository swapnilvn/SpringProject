package com.mongo.crud.presentation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.crud.business.dto.ItsEntityDto;
import com.mongo.crud.business.service.ItsService;

@RestController
public class ItsController {

	@Autowired
	ItsService itsService;
	
	@PostMapping("/save")
	public Map<String, Object>save(@Valid @RequestBody ItsEntityDto itsEntityDto, BindingResult bindingResult)
	{
		Map<String, Object>map = new HashMap<>();
		if(bindingResult.hasErrors())
		{
			System.out.println(bindingResult.getAllErrors());
		}
		map = itsService.save(itsEntityDto);
		return map;
	}
	
	@PostMapping("/getAll")
	public Map<String, Object>getData()
	{
		Map<String, Object>map = new HashMap<>();
		map = itsService.getData();
		return map;
	}
}
