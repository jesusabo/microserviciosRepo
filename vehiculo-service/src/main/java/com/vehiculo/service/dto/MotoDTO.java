package com.vehiculo.service.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.vehiculo.service.entity.Carro;
import com.vehiculo.service.entity.Moto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class MotoDTO {

	private int id;
	
	@Size(min = 3, message = "La marca debe tener al menos 3 caracteres")
	private String marca;
	
	
	@Size(min = 3, message = "El modelo debe tener al menos 3 caracteres")
	private String modelo;
	
	@NotEmpty(message = "Debe ingresar una fecha de creacion")
	private Date fechaCreacion;
	
	@NotEmpty(message = "Debe ingresar un ID de usuario")
	private int idUsuario;
	
	@NotEmpty(message = "Debe ingresar el numero de ruedas")
	private int numeroRuedas;

	public MotoDTO(Moto moto) {
		super();
		this.id = moto.getId();
		this.marca = moto.getMarca();
		this.modelo = moto.getModelo();
		this.fechaCreacion = moto.getFechaCreacion();
		this.idUsuario = moto.getIdUsuario();
		this.numeroRuedas = moto.getNumeroRuedas();
	}
	
	
}
