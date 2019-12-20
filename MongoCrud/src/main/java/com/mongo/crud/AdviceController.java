package com.mongo.crud;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mongo.crud.exception.BussinessException;
import com.mongo.crud.exception.ContractException;
import com.mongo.crud.exception.TechnicalException;


@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

	
	Logger log = Logger.getLogger(AdviceController.class);

	@ExceptionHandler(BussinessException.class)
	public ResponseEntity<Object> handleInvalidOTPException(BussinessException e){
		log.error("Detailed Exception!", e);
		Map<String, Object> errors=new HashMap<>();
		errors.put(e.getErrorcode().toString(), e.getDescription());
		return new ResponseEntity<>(errors, e.getErrorcode());
	}
	
	@ExceptionHandler(ContractException.class)
	public ResponseEntity<Object> handleInvalidOTPException(ContractException e){
		log.error("Detailed Exception!", e);
		Map<String, Object> errors=new HashMap<>();
		errors.put(e.getErrorcode().toString(), e.getDescription());
		return new ResponseEntity<>(errors, e.getErrorcode());
		
	}
	
	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<Object> handleInvalidOTPException(TechnicalException e){
		log.error("Detailed Exception!", e);
		Map<String, Object> errors=new HashMap<>();
		errors.put(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getDescription());
		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
