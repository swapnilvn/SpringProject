
package com.swapnil.HibernateCriteria.presentation.controller;

import java.util.HashMap;
import java.util.Map;

import com.swapnil.HibernateCriteria.business.dto.EmployeeDTO;
import com.swapnil.HibernateCriteria.business.dto.SearchEmpDto;
import com.swapnil.HibernateCriteria.business.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;
    private Logger logger = LoggerFactory.getLogger(EmpController.class);

    @PostMapping("/save")
    public Map<String, Object>saveIt(@RequestBody EmployeeDTO empDTO)
    {
    	Map<String, Object> map = new HashMap<>();
    	map = empService.saveEmp(empDTO);
    	return map;
    }
    
    @PostMapping("/get")
    public Map<String, Object> get(@RequestBody SearchEmpDto searchEmpDto)
    {
    	Map<String, Object>map = new HashMap<>();
    	map = empService.get(searchEmpDto);
    	return map;
    }

}
