package com.swap.demo.service;

import java.util.Map;

import com.swap.demo.dto.MasaDto;

public interface MasaService {

	Map<String, Object> krSave(MasaDto masaDto);

	Map<String, Object> getData();

	Map<String, Object> getById(Long id, Boolean active);

	Long deleteById(Long id);

	Map<String, Object> activeInactive(Long id, Boolean active);
}
