package com.swapnil.curd.business.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SwapnilDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Long points;
	private String cur_Date;
	private String cur_time;
	private String dob;
}
