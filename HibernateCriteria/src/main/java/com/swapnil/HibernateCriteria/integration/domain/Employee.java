
package com.swapnil.HibernateCriteria.integration.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@EntityListeners(org.springframework.data.jpa.domain.support.AuditingEntityListener.class)
public class Employee implements Serializable
{

    private String code;
    private Double price;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long subCategoryID;
    private Long categoryID;
    private Date createdOn;
    private Date modifyOn;
}
