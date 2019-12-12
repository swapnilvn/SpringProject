package com.swap.ImportJarTwo.business.serviceImpl;

import org.springframework.stereotype.Service;

import com.swap.ImportJarOne.business.serviceimpl.ImportJarOneServiceImpl;
import com.swap.ImportJarTwo.business.service.ImportJarTwoService;

@Service
public class ImportJarTwoServiceImpl implements ImportJarTwoService {

	@Override
	public Integer mul(Integer first, Integer two) 
	{

		return first * two;
	}

	ImportJarOneServiceImpl importJarOneServiceImpl = new ImportJarOneServiceImpl();

	@Override
	public Integer callJarAdd(Integer first, Integer two) 
	{

		return importJarOneServiceImpl.add(first, two);
	}

}
