package com.swapnil.curd.business.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class GetSwapnilDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Long points;
	private String dob;
	private Date cur_time;
}
