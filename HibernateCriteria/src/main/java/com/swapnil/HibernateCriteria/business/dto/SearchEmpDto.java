package com.swapnil.HibernateCriteria.business.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SearchEmpDto implements Serializable{
	
	 	private String code;
	    private Double price;
	    private Double Mprice;
	    private Double Lprice;
	    private List<Double> priceList;
	    private String name;
	    private Long id;
	    private Long subCategoryID;
	    private Long categoryID;
	    private Date createdOn;
	    private Date modifyOn;
}
