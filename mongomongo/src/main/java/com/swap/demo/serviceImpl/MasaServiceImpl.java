package com.swap.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swap.demo.domain.Masa;
import com.swap.demo.dto.MasaDto;
import com.swap.demo.repository.MasaRepository;
import com.swap.demo.service.MasaService;

@Service
public class MasaServiceImpl implements MasaService {
	
	@Autowired
	private MasaRepository masaRepository;

	@Override
	public Map<String, Object> krSave(MasaDto masaDto) 
	{
		Map<String, Object>map = new HashMap<String, Object>();
		Masa masa = null;
		if(masaDto != null)
		{
			masa = new Masa();
			BeanUtils.copyProperties(masaDto, masa);
			masa.setDob(new Date());
			masaRepository.save(masa);
		}
		map.put("200", "Done");
		return map;
	}
	
	@Override
	public Map<String, Object> getData() 
	{
		Map<String, Object>map = new HashMap<String, Object>();
		MasaDto masaDto = null;
		List<MasaDto> dtosList = new ArrayList<>();
		List<Masa> masas = masaRepository.findAll();
		for(Masa masa : masas)
		{
			masaDto = new MasaDto();
			BeanUtils.copyProperties(masa, masaDto);
			dtosList.add(masaDto);
		}
		map.put("dtosList", dtosList);
		return map;
	}

}
