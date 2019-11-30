
package com.swapnil.HibernateCriteria.business.service;

import java.util.Map;

import com.swapnil.HibernateCriteria.business.dto.EmployeeDTO;
import com.swapnil.HibernateCriteria.business.dto.SearchEmpDto;

public interface EmpService {

	Map<String, Object> saveEmp(EmployeeDTO empDTO);

	Map<String, Object> get(SearchEmpDto searchEmpDto);


}
