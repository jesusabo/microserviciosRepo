package com.usuario.service.excepciones;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> manejarRecursoNoEncontrado(ResourceNotFoundException exception, WebRequest webRequest){
		Map<String,Object> map = new HashMap<>();
		map.put("Fecha", new Date());
		map.put("Exception", exception.getMessage());
		map.put("Description", webRequest.getDescription(false));
		map.put("Codigo de Error", "001");
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error ->{
			String nombreCampo = ((FieldError)error).getField();
			String mensaje = error.getDefaultMessage();
			
			errores.put(nombreCampo, mensaje);
		});
		
		
		return new ResponseEntity<>(errores,HttpStatus.BAD_REQUEST);
	}
	
}
