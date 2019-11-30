package com.swapnil.RestCalled.presentation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapnil.RestCalled.business.service.ItsUserService;

@RestController
public class ItsController {

		@Autowired
		private ItsUserService itsUserService;
		
		@PostMapping("/called")
		public Map<String, Object> callingRestData()
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map = itsUserService.callRestCallData();
			return map;
		}
}
