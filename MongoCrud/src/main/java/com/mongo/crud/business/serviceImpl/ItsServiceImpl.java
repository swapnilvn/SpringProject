package com.mongo.crud.business.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.crud.business.dto.ItsEntityDto;
import com.mongo.crud.business.service.ItsService;
import com.mongo.crud.integration.domain.ItsEntity;
import com.mongo.crud.integration.repository.ItsRepository;

@Service
public class ItsServiceImpl implements ItsService {
	
	@Autowired
	ItsRepository itsRepository;

	@Override
	public Map<String, Object> save(ItsEntityDto itsEntityDto) {
		Map<String, Object>map = new HashMap<String, Object>();
		ItsEntity itsEntity = null;
		if(itsEntityDto != null)
		{
			itsEntity = new ItsEntity();
			BeanUtils.copyProperties(itsEntityDto, itsEntity);
			itsRepository.save(itsEntity);
			map.put("200", "Done");
		}
		return map;
	}

	@Override
	public Map<String, Object> getData() {
		Map<String, Object>map = new HashMap<String, Object>();
		ItsEntityDto itsEntityDto = null;
		java.util.List<ItsEntityDto> itsEntityDtoList = new ArrayList<>();
		java.util.List<ItsEntity> itsEntityList = itsRepository.findAll();
		for(ItsEntity entity : itsEntityList)
		{
			itsEntityDto = new ItsEntityDto();
			BeanUtils.copyProperties(entity, itsEntityDto);
			itsEntityDtoList.add(itsEntityDto);
		}
		map.put("itsEntityDto's", itsEntityDtoList);
		return map;
	}

}
