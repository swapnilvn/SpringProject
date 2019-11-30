
package com.swapnil.HibernateCriteria.business.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapnil.HibernateCriteria.business.dto.EmployeeDTO;
import com.swapnil.HibernateCriteria.business.dto.SearchEmpDto;
import com.swapnil.HibernateCriteria.business.service.EmpService;
import com.swapnil.HibernateCriteria.integration.domain.Employee;
import com.swapnil.HibernateCriteria.integration.repository.EmpRepository;

@Service
public class EmpServiceImpl
    implements EmpService
{

    @Autowired
    private EmpRepository empRepository;

	@Override
	public Map<String, Object> saveEmp(EmployeeDTO empDTO) {
		Map<String, Object> map = new HashMap<>();
		Employee emp = null;
		if(empDTO != null)
		{
			if(empDTO.getId() != null && empDTO.getId() != 0L)
			{
				emp = empRepository.findOne(empDTO.getId());
				if(emp != null)
				{
					BeanUtils.copyProperties(empDTO, emp);
					emp.setModifyOn(new Date());
					empRepository.save(emp);
					map.put("200", "updated");
				}
			}
			else
			{
				emp = new Employee();
				BeanUtils.copyProperties(empDTO, emp);
				emp.setCreatedOn(new Date());
				empRepository.save(emp);
				map.put("200", "saved");
			}
		}
		return map;
	}

	
	@PersistenceContext
	EntityManager em;
	
	/*------------------------------------------BASIC QUERY--------------------------------------------*/
	
	@Override
	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
		Map<String, Object> map = new HashMap<>();
		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
		List<Employee> results = cr.list();
		map.put("List", results);
		return map;
	}
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		cr.add(Restrictions.eq("name", searchEmpDto.getName()));
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
    
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		cr.add(Restrictions.gt("price", searchEmpDto.getPrice()));
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		
//		cr.add(Restrictions.ilike("name", searchEmpDto.getName()+"%"));
//
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		
//		cr.add(Restrictions.between("price", searchEmpDto.getLprice(), searchEmpDto.getMprice()));
//
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		
//		cr.add(Restrictions.in("price", searchEmpDto.getPriceList()));
//
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
	
	/*------------------------------------------OR--------------------------------------------*/
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		
//		Criterion price = Restrictions.eq("price", searchEmpDto.getPrice());
//		Criterion name = Restrictions.ilike("name",searchEmpDto.getName()+"%");
//		// To get records matching with OR conditions
//		LogicalExpression orExp = Restrictions.or(price, name);
//		cr.add( orExp );
//
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
	
	/*------------------------------------------AND--------------------------------------------*/
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		
//		Criterion price = Restrictions.eq("price", searchEmpDto.getPrice());
//		Criterion name = Restrictions.ilike("name",searchEmpDto.getName()+"%");
//		// To get records matching with OR conditions
//		LogicalExpression orExp = Restrictions.and(price, name);
//		cr.add( orExp );
//
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
	
	/*-----------------------------------Pagination Using Criteria------------------------------*/ 
	
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		
//		//Start from 2
//		cr.setFirstResult(2);
//		
//		//Max count length List 5
//		cr.setMaxResults(5);
//
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
	
	/*-----------------------------------Sorting the Results------------------------------*/ 
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		
//		//cr.add(Restrictions.ilike("name", searchEmpDto.getName()+"%"));
//		
//		// To sort records in descening order
//		cr.addOrder(Order.desc("name"));
//
//		// To sort records in ascending order
//		//cr.addOrder(Order.asc("name"));
//		
//		List<Employee> results = cr.list();
//		map.put("List", results);
//		return map;
//	}
	
	/*-----------------------------------Other------------------------------*/ 
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//	
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		List<Employee> results = cr.list();
//		
//		for (Iterator iterator = results.iterator(); iterator.hasNext(); )
//		{
//            Employee employee = (Employee) iterator.next();
//            
//            System.out.print("First Name: " + employee.getName()); 
//            System.out.print("  price: " + employee.getPrice()); 
//            System.out.print("  Code: " + employee.getCode());
//            System.out.println("  Id: " +employee.getId());
//         }
//		
//		map.put("List", results);
//		return map;
//	}
	
//	@Override
//	public Map<String, Object> get(SearchEmpDto searchEmpDto) {
//		Map<String, Object> map = new HashMap<>();
//	
//		Criteria cr = em.unwrap(Session.class).createCriteria(Employee.class);
//		List<Employee> results = cr.list();
//		
//		for (Iterator iterator = results.iterator(); iterator.hasNext(); )
//		{
//            Employee employee = (Employee) iterator.next();
//            
//            System.out.print("First Name: " + employee.getName()); 
//            System.out.print("  price: " + employee.getPrice()); 
//            System.out.print("  Code: " + employee.getCode());
//            System.out.println("  Id: " +employee.getId());
//         }
//		
//		map.put("List", results);
//		return map;
//	}

}
