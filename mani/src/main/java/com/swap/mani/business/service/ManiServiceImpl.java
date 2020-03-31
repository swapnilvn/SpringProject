package com.swap.mani.business.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Service;

import com.swap.mani.business.dto.ManiDto;
import com.swap.mani.exception.BussinessException;
import com.swap.mani.exception.ContractException;
import com.swap.mani.exception.TechnicalException;
import com.swap.mani.integration.domain.Mani;
import com.swap.mani.integration.domain.ManiAddressMapping;
import com.swap.mani.integration.repository.ManiAddressMappingRepository;
import com.swap.mani.integration.repository.ManiRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ManiServiceImpl implements ManiService {
	
	@Autowired
	ManiRepository maniRepository;
	
	@Autowired
	ManiAddressMappingRepository maniAddressMappingRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public Map<String, Object> save(ManiDto maniDto) {
		Map<String, Object>map = new HashedMap<>();
		
		Mani mani = null;
		mani = maniRepository.findOne(maniDto.getId());
		if(mani != null)
		{
			BeanUtils.copyProperties(maniDto, mani);
			mani.setModifiedOn(new Date());
		}
		else
		{
			mani = new Mani();
			BeanUtils.copyProperties(maniDto, mani);
			mani.setCreatedOn(new Date());
		}
		mani.setDob(new Date());
		Long id = maniRepository.save(mani).getId();
		
		//Mani and Address List mapping
		List<ManiAddressMapping> maniAddressMappingList = new ArrayList<>();
		for(String addss : maniDto.getAddess())
		{
			ManiAddressMapping maniAddressMapping = ManiAddressMapping.builder().maniId(id).address(addss).build();
			maniAddressMappingList.add(maniAddressMapping);
		}
		maniAddressMappingRepository.save(maniAddressMappingList);
		
		map.put("200", "saved");
		return map;
	}

	@Override
	public Map<String, Object> getOne(Long id){
		Map<String, Object>map = new HashedMap<>();
		Mani mani = maniRepository.findOne(id);
		if(mani == null)
		{
			map.put("404", "not found");
		}
		else
		{
			ManiDto maniDto = new ManiDto();
			BeanUtils.copyProperties(mani, maniDto);
			maniDto.setDob(formater.format(mani.getDob()));
			List<ManiAddressMapping> maniAddressMappingList = maniAddressMappingRepository.findByManiId(id);
			List<String> adressess = new ArrayList<>();
			for(ManiAddressMapping mam : maniAddressMappingList)
			{
				String ad = mam.getAddress();
				adressess.add(ad);
			}
			maniDto.setAddess(adressess);
			map.put("maniDto", maniDto);
		}
		return map;
	}

	@Override
	@Transactional
	public Map<String, Object> delete(Long id) {
		Map<String, Object>map = new HashedMap<>();
		maniRepository.deleteById(id);
		return map;
	}
	
	//------------------------------------------------------------------------------------------------------
	
	@Override
	public Map<String, Object> PaginationCriteria(
			int draw, int start, int length, String columns, String search, String sortOrder, String sortField,
			String searchCol, boolean booleanfield) throws TechnicalException, BussinessException, ContractException {
		Map<String, Object> map = new HashMap<>();
		PageRequest pageRequest = null;
		
		String decodedSearch = search ;
		if (sortField.equalsIgnoreCase("name")) 
		{
			pageRequest = new PageRequest(start, length, org.springframework.data.domain.Sort.Direction.fromString(sortOrder), "name");
		} 
		else 
		{
			pageRequest = new PageRequest(start, length, org.springframework.data.domain.Sort.Direction.fromString(sortOrder), sortField);
		}
		
		List<ManiDto> dtolist = new ArrayList<>();
		
		Page<Mani> list = paginate(decodedSearch, searchCol, pageRequest, booleanfield);
		List<Mani> newlist = list.getContent();
		Long totalCount = list.getTotalElements();
		
		if (newlist != null && !newlist.isEmpty()) 
		{
			for (Mani obj : newlist) {
				ManiDto dto = new ManiDto();
				BeanUtils.copyProperties(obj, dto);

				log.info("simpleDateFormat ----->");
				if (obj.getCreatedOn() != null) {

					String createdOn = formater.format(obj.getCreatedOn());
					dto.setCreatedOn(createdOn);
				}

				if (obj.getModifiedOn() != null) {
					String modifiedOn = formater.format(obj.getModifiedOn());
					dto.setModifiedOn(modifiedOn);
				}

				dtolist.add(dto);
			}
		}

		if (dtolist != null && !dtolist.isEmpty()) 
		{
			map.put("ManiDto", dtolist);
			map.put("totalCount", totalCount);
		} 
		else 
		{
			map.put("ManiDto", dtolist);
			map.put("totalCount", 0);
		}
		
		return map;
	}

	private Page<Mani> paginate(String search, String searchcolumn, Pageable pageable, boolean booleanfield) throws TechnicalException, BussinessException, ContractException
	{

		Date newDate = null;

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Mani> criteria = builder.createQuery(Mani.class);
		Root<Mani> root = criteria.from(Mani.class);
		List<Predicate> predicates = new ArrayList<>();
		String likesymbol = "%";
		Predicate activepredicate = builder.equal(root.get("active"), booleanfield);

		if ((searchcolumn != null) && (!searchcolumn.isEmpty())) 
		{
			if (searchcolumn.equals("createdOn")) 
			{
				Date date = new Date(Long.valueOf(search));
				newDate = date;
				predicates.add(builder.lessThanOrEqualTo(root.get("createdOn").as(java.sql.Date.class), getGreaterThanDate(newDate)));
				predicates.add(builder.greaterThanOrEqualTo(root.get("createdOn").as(java.sql.Date.class), getLessThanDate(newDate)));
			}
			else if (searchcolumn.equals("createdBy") || searchcolumn.equals("modifiedBy")) 
			{
				try {
					predicates.add(builder.equal(root.get(searchcolumn), Long.parseLong(search)));
				} catch (NumberFormatException e) 
				{
					log.error("numeric search was a string in pagination ");
				}
			} else {
				predicates.add(builder.like(builder.lower(root.get(searchcolumn)), likesymbol.concat(search.toLowerCase()).concat(likesymbol)));

			}
		} else 
		{
			predicates.add(builder.like(builder.lower(root.get("name")), likesymbol.concat(search.toLowerCase()).concat(likesymbol)));
		}
		Predicate searchpredicatevar = builder.and(predicates.toArray(new Predicate[predicates.size()]));
		criteria.where(builder.and(searchpredicatevar, activepredicate));
		criteria.orderBy(QueryUtils.toOrders(pageable.getSort(), root, builder));
		List<Mani> result = entityManager.createQuery(criteria).setFirstResult(pageable.getOffset())
				.setMaxResults(pageable.getPageSize()).getResultList();
		List<Mani> result1 = entityManager.createQuery(criteria).getResultList();
		Integer count = result1.size();
		return new PageImpl<>(result, pageable, count);
	}

	public Date getLessThanDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);

		return calendar.getTime();
	}

	public Date getGreaterThanDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

}
