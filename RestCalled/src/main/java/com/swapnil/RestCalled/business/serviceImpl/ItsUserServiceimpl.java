package com.swapnil.RestCalled.business.serviceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
	public Map<String, Object> callRestCallData() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
		
//		ResponseEntity<OneEntity[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, OneEntity[].class);
		ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, List.class);
		
		displayObjectContaints(responseEntity);
		
		map.put("statusCode", responseEntity.getStatusCode());
		map.put("Headers", responseEntity.getHeaders());
		map.put("Data", responseEntity.getBody());
		return map;
	}
	
	public void displayObjectContaints(ResponseEntity<List> listObj)
	{
		for(Object oo : listObj.getBody())
		{
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------START");
			System.out.println(oo.toString());
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------END");
		}
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
