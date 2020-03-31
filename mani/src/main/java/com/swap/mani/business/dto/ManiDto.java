package com.swap.mani.business.dto;

import java.util.List;

import lombok.Data;

@Data
public class ManiDto {

	private Long id;
	private String color;
	private String name;
	private Integer age;
	private String dob;
	
	private List<String> addess;
	
	private String createdOn;
	private String modifiedOn;
}
