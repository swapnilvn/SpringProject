package com.swapnil.curd.integration.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String employee_name;
	private Double employee_salary;
	private Integer employee_age;
	private String profile_image;
	

}
