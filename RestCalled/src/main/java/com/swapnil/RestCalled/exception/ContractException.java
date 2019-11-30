package com.swapnil.RestCalled.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class ContractException extends Throwable {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus errorcode;

	private String description;

	private BindingResult bindingResult;

	public HttpStatus getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(HttpStatus errorcode) {
		this.errorcode = errorcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public ContractException(BindingResult bindingResult) {
		super();
		this.bindingResult = bindingResult;
	}

	public ContractException(HttpStatus errorcode, String description) {
		super();
		this.errorcode = errorcode;
		this.description = description;
	}
}
