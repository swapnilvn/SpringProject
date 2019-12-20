package com.mongo.crud.business.service;

import java.util.Map;

import com.mongo.crud.business.dto.ItsEntityDto;

public interface ItsService {

	Map<String, Object> save(ItsEntityDto itsEntityDto);

	Map<String, Object> getData();

}
