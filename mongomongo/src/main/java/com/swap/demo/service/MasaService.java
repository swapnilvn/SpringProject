package com.swap.demo.service;

import java.util.Map;

import com.swap.demo.dto.MasaDto;

public interface MasaService {

	Map<String, Object> krSave(MasaDto masaDto);

	Map<String, Object> getData();

}
