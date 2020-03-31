package com.swap.mani.integration.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Mani implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String color;
	private String name;
	private Integer age;
	private Date dob;
	private Date createdOn;
	private Date modifiedOn;
	private Boolean active = true;
	
}
