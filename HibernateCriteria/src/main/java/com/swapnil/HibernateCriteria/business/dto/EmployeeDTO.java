
package com.swapnil.HibernateCriteria.business.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO implements Serializable
{

    private String code;
    private Double price;
    private String name;
    private Long id;
    @NotNull
    private Long subCategoryID;
    private Long categoryID;

}
