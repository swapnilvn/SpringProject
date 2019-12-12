package com.swap.ImportJarOne.business.serviceimpl;

import org.springframework.stereotype.Service;

import com.swap.ImportJarOne.business.service.ImportJarOneService;

@Service
public class ImportJarOneServiceImpl implements ImportJarOneService {

	@Override
	public Integer add(Integer fno, Integer sno)
	{
		return fno + sno;
	}

	


}
