package com.vehiculo.service.excepciones;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public ResponseEntity<Object> manejarRecursoNoEncontrado(UsuarioNoEncontradoException exception, WebRequest webRequest){
		Map<String,Object> map = new HashMap<>();
		map.put("Fecha", new Date());
		map.put("Exception", exception.getMessage());
		map.put("Description", webRequest.getDescription(false));
		map.put("Codigo de Error", "001C");
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
	}

}
