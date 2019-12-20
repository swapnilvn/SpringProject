package com.swapnil.RestCalled.business.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swapnil.RestCalled.business.service.ItsUserService;
import com.swapnil.RestCalled.integration.domain.OneEntity;

@Service
public class ItsUserServiceimpl implements ItsUserService{
	
	@Autowired // Bean from Application.java File
	private RestTemplate restTemplate;

	@Override
	public Map<String, Object> callRestCallData() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String url = "https://jsonplaceholder.typicode.com/posts";
		ResponseEntity<OneEntity[]> response = restTemplate.exchange(url, HttpMethod.GET,null,OneEntity[].class);
		
//		for(OneEntity en : response.getBody())
//		{
//			System.out.println(en.getId()+" "+en.getTitle()+" "+en.getBody());
//		}
		
		map.put("Data", response.getBody());
		return map;
	}
	
	@Override
	public Map<String, Object> getObjectList() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		String url = "https://jsonplaceholder.typicode.com/posts";
		Object[] objectArray = restTemplate.getForObject(url, Object[].class);
		
		map.put("Data", Arrays.asList(objectArray));
		return map;
	}
	

}
