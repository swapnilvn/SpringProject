package com.swapnil.RestCalled.business.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swapnil.RestCalled.business.service.ItsUserService;
import com.swapnil.RestCalled.integration.domain.OneEntity;

@Service
public class ItsUserServiceimpl implements ItsUserService{

	@Override
	public Map<String, Object> callRestCallData() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		ResponseEntity<OneEntity[]> response = restTemplate.exchange(url, HttpMethod.GET,null,OneEntity[].class);
		
		for(OneEntity en : response.getBody())
		{
			System.out.println(en.getId()+" "+en.getTitle()+" "+en.getBody());
		}
		
		map.put("Data", response.getBody());
		return map;
	}
	

}
