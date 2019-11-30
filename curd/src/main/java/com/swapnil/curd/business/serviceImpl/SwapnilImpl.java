package com.swapnil.curd.business.serviceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapnil.curd.business.dto.GetSwapnilDto;
import com.swapnil.curd.business.dto.SwapnilDto;
import com.swapnil.curd.business.service.SwapnilService;
import com.swapnil.curd.integration.domain.Swapnil;
import com.swapnil.curd.integration.repository.SwapnilRepository;

@Service
public class SwapnilImpl implements SwapnilService {

	@Autowired
	SwapnilRepository swapnilRepository;

	@Override
	public Map<String, Object> saveData(GetSwapnilDto getSwapnilDto) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		Swapnil swapnil = null;
		if (getSwapnilDto != null) {
			if (getSwapnilDto.getId() != null && getSwapnilDto.getId() != 0L) {
				swapnil = swapnilRepository.findOne(getSwapnilDto.getId());
				BeanUtils.copyProperties(getSwapnilDto, swapnil);
				swapnil.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(getSwapnilDto.getDob()));
				swapnilRepository.save(swapnil);
				map.put("200", "Data updated Successfully");
			} else {
				swapnil = new Swapnil();
				BeanUtils.copyProperties(getSwapnilDto, swapnil);
				swapnil.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(getSwapnilDto.getDob()));
				swapnilRepository.save(swapnil);
				map.put("200", "Data Saved Successfully");
			}
		}
		return map;
	}

	// Method retun all records with return type map
	public Map<String, Object> getAllData() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm a");
		List<SwapnilDto> dtosList = new ArrayList<>();
		List<Swapnil> swapnilList = swapnilRepository.findAll();
		for (Swapnil swapnil : swapnilList)
		{
			SwapnilDto swapnilDto = new SwapnilDto();
			BeanUtils.copyProperties(swapnil, swapnilDto);
			swapnilDto.setCur_Date(simpleDateFormat.format(swapnil.getCur_time()));
			swapnilDto.setCur_time(simpleDateFormat1.format(swapnil.getCur_time()));
			swapnilDto.setDob(simpleDateFormat.format(swapnil.getDob()));
			dtosList.add(swapnilDto);
		}
		map.put("Records", dtosList);
		return map;
	}

	public Map<String, Object> getData() {
		Map<String, Object> map = new HashMap<>();
		map = getAllData();
		return map;
	}

	public Map<String, Object> show() throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object>map=new HashMap<>();
		
		String url = "http://dummy.restapiexample.com/api/v1/employees";
		String result = restTemplate.getForObject(url, String.class);
		System.out.println(result);
	
		map.put("listOfEmp", result);
		return map;
	}
	
	public Map<String, Object> nn()
	{
		Swapnil swapnil = new Swapnil();
		swapnil.setId(111L);
		swapnil.setName("chandramukhi");
		swapnil.setPoints(001L);
		
		Swapnil swapnil1 = new Swapnil();
		swapnil1.setId(111L);
		swapnil1.setName("chandramukhi");
		swapnil1.setPoints(001L);
		
		List<Swapnil> list = new ArrayList<>();
		list.add(swapnil);
		list.add(swapnil1);
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("Records", list);
		
		ObjectMapper mapper = new ObjectMapper();
		Swapnil[] pojo = mapper.convertValue(dataMap.get("Records"), Swapnil[].class);
		
		for(Swapnil swap : pojo)
		{
			System.out.println(swap.getId()+" "+swap.getName()+" "+swap.getPoints());
		}
		
		return null;
	}
}
