package com.swapnil.Swagger.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapnil.Swagger.domain.Mosambi;
import com.swapnil.Swagger.dto.MosambiDto;
import com.swapnil.Swagger.repository.MosambiRepository;
import com.swapnil.Swagger.service.MosambiService;

@Service
public class MosambiServiceImpl implements MosambiService{
	
	@Autowired
	private MosambiRepository mosambiRepository;

	public Map<String, Object> ss(MosambiDto mosambiDto) {
		Map<String, Object>map = new HashMap<String, Object>();
		Mosambi mosambi = null;
		if(mosambiDto!=null)
		{
			mosambi = new Mosambi();
			BeanUtils.copyProperties(mosambiDto, mosambi);
			mosambiRepository.save(mosambi);
			map.put("200", "done");
		}
		return map;
	}

	@Override
	public Map<String, Object> show() {
		Map<String, Object>map = new HashMap<String, Object>();
		List<Mosambi> mosambiList = null;
		List<MosambiDto> mosambiDtoList = new ArrayList<MosambiDto>();
		MosambiDto mosambiDto = null;
		mosambiList = mosambiRepository.findAll();
		if(!mosambiList.isEmpty())
		{
			for(Mosambi mosambi : mosambiList)
			{
				mosambiDto = new MosambiDto();
				BeanUtils.copyProperties(mosambi, mosambiDto);
				mosambiDtoList.add(mosambiDto);
			}
			map.put("List", mosambiDtoList);
		}
		return map;
	}

	@Override
	public Map<String, Object> cool(String color) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<Mosambi> mosambiList = null;
		List<MosambiDto> mosambiDtoList = new ArrayList<MosambiDto>();
		MosambiDto mosambiDto = null;
		
		mosambiList = mosambiRepository.findByPrice(color);
		if(!mosambiList.isEmpty())
		{
			for(Mosambi mosambi : mosambiList)
			{
				mosambiDto = new MosambiDto();
				BeanUtils.copyProperties(mosambi, mosambiDto);
				mosambiDtoList.add(mosambiDto);
			}
			map.put("List", mosambiDtoList);
		}
		return map;
	}

}
