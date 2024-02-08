package com.vehiculo.service.excepciones;

public class UsuarioNoEncontradoException extends RuntimeException{


	private static final long serialVersionUID = 7559894241544936479L;

	private String nombreDelRecurso;
	private int nombreDelCampo;
	private String error;
	
	
	public UsuarioNoEncontradoException(String nombreDelRecurso, int nombreDelCampo, String error) {
		super(String.format("%s no encontrado - Id : %s - error: %s", nombreDelRecurso, nombreDelCampo, error));
		this.nombreDelRecurso = nombreDelRecurso;
		this.nombreDelCampo = nombreDelCampo;
		this.error = error;
	}
}
