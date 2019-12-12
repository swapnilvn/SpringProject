package com.swap.ImportJarTwo.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swap.ImportJarTwo.business.service.ImportJarTwoService;

@RestController
public class ImportJarTwoController {

	@Autowired
	ImportJarTwoService importJarTwoService;

	@PostMapping("mul")
	public Integer mul(@RequestParam("first") Integer first, @RequestParam("two") Integer two) 
	{
		return importJarTwoService.mul(first, two);
	}
	
	@PostMapping("callJarAdd")
	public Integer callJarAdd(@RequestParam("first") Integer first, @RequestParam("two") Integer two) 
	{
		return importJarTwoService.callJarAdd(first, two);
	}

}
