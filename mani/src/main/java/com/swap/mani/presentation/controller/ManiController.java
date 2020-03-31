package com.swap.mani.presentation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swap.mani.business.dto.ManiDto;
import com.swap.mani.business.service.ManiService;
import com.swap.mani.exception.BussinessException;
import com.swap.mani.exception.ContractException;
import com.swap.mani.exception.TechnicalException;

import lombok.extern.log4j.Log4j;

@CrossOrigin("*")
@RestController
@Log4j
public class ManiController {
	
	@Autowired
	ManiService maniService;
	
	@PostMapping("/save")
	public Map<String, Object>save(@RequestBody ManiDto maniDto)
	{
		return maniService.save(maniDto);
	}
	
	@PostMapping("/getOne")
	public Map<String, Object>getOne(@RequestParam("id") Long id)
	{
		return maniService.getOne(id);
	}
	
	@PostMapping("/delete")
	public Map<String, Object>delete(@RequestParam("id") Long id)
	{
		return maniService.delete(id);
	}

	//----------------------------------------------
	@PostMapping("/getAllDataPagination")
	public Map<String, Object> defaultRender(
			@RequestParam(defaultValue = "0", value = "draw", required = false) int draw,
			@RequestParam(defaultValue = "0", value = "start", required = false) int start,
			@RequestParam(defaultValue = "10", value = "length", required = false) int length,
			@RequestParam(defaultValue = "", value = "columns", required = false) String columns,
			@RequestParam(defaultValue = "", value = "search", required = false) String search,
			@RequestParam(defaultValue = "desc", value = "sortOrder", required = false) String sortOrder,
			@RequestParam(defaultValue = "id", value = "sortField", required = false) String sortField,
			@RequestParam(defaultValue = "", value = "searchCol", required = false) String searchCol,
			@RequestParam(defaultValue = "true", value = "booleanfield", required = true) boolean booleanfield
			) throws TechnicalException, BussinessException, ContractException {
		return maniService.PaginationCriteria(draw, start,
				length, columns, search, sortOrder, sortField, searchCol, booleanfield);
	}
}
