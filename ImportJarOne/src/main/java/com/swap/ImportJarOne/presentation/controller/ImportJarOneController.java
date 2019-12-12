package com.swap.ImportJarOne.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swap.ImportJarOne.business.service.ImportJarOneService;

@RestController
public class ImportJarOneController {

	@Autowired
	ImportJarOneService importJarOneService;
	
	@PostMapping("/add")
	public Integer add(@RequestParam("fno") Integer fno, @RequestParam("sno") Integer sno)
	{
		return importJarOneService.add(fno, sno);
	}
}
