package com.carro.service.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarroError extends RuntimeException{

	private static final long serialVersionUID = 5716344771418537063L;
	
	
	private String codigoError;
	private int valorDelCampo;
	private String nombreDelRecurso;
	
	
	public CarroError(String nombreDelRecurso, int valorDelCampo,String codigoError) {
		super(String.format("%s con id: %s no encontrado - error: '%s'", nombreDelRecurso, valorDelCampo, codigoError));
		this.codigoError=codigoError;
		this.nombreDelRecurso= nombreDelRecurso;
		this.valorDelCampo = valorDelCampo;
	}

}
