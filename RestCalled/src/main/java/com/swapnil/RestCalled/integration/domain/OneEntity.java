
package com.swapnil.RestCalled.integration.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OneEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer userId;
    private Integer id;
   private String title;
   private String body;
   
}
