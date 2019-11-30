package com.swapnil.HibernateCriteria.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	Logger logger =  LoggerFactory.getLogger(TestController.class.getName());
	
	@GetMapping("/")
	public String testHandler() {
		logger.info("Hello Info");
		logger.debug("Hello debug");
		logger.warn("Hello warn");
		logger.error("Hello error");
		logger.trace("Hello trace");
		
		return "Hello";
	}

}
