package com.swap.mani.business.service;

import java.util.Map;

import com.swap.mani.business.dto.ManiDto;
import com.swap.mani.exception.BussinessException;
import com.swap.mani.exception.ContractException;
import com.swap.mani.exception.TechnicalException;

public interface ManiService {

	Map<String, Object> save(ManiDto maniDto);

	Map<String, Object> getOne(Long id);

	Map<String, Object> delete(Long id);

	Map<String, Object> PaginationCriteria(int draw, int start, int length, String columns, String search,
			String sortOrder, String sortField, String searchCol, boolean booleanfield) throws TechnicalException, BussinessException, ContractException;

}
