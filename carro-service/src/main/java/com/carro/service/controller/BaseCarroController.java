package com.carro.service.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BaseCarroController extends ResponseEntityExceptionHandler{

	protected static final Logger log = org.slf4j.LoggerFactory.getLogger(BaseCarroController.class);
	
	
	@ExceptionHandler(CarroError.class)
	public ResponseEntity<Object> exceptionHandler(CarroError ex, WebRequest webRequest) {
		Map<String , Object> map = new HashMap<>();
		map.put("Description", webRequest.getDescription(false));
		map.put("Fecha", new Date());
		map.put("Codigo de Error", "000011");		
		map.put("Microservicio", "carro");
		map.put("Exception", ex.getMessage());		
		log.error("Error interno");
		return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
