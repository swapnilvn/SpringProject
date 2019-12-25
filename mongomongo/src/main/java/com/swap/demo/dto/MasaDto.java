package com.swap.demo.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MasaDto implements Serializable{

	private Long id;
	private String name;
	private Date dob;
	private Boolean active = Boolean.TRUE;
	
}
