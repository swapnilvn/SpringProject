package com.swap.demo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Masa implements Serializable{
	
	private Long id;
	private String name;
	private Date dob;
	private Boolean active;
}
