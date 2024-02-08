package com.vehiculo.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vehiculo.service.entity.Carro;

import lombok.Data;

@Data
public class CarroDTO implements Serializable{
	
	private static final long serialVersionUID = -8665036970605643753L;

	private int id;
	
	@Size(min = 3, message = "La marca debe tener al menos 3 caracteres")
	private String marca;
	
	
	@Size(min = 3, message = "El modelo debe tener al menos 3 caracteres")
	private String modelo;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Debe ingresar una fecha de creacion")
	private Date fechaCreacion;
	
	@NotNull(message = "Debe ingresar un ID de usuario")
	private int idUsuario;
	
	@NotNull(message = "Debe ingresar el numero de puertas")
	private int numeroPuertas;
	
	public CarroDTO(){
		
	}

	public CarroDTO(Carro carro) {
		this.id = carro.getId();
		this.marca = carro.getMarca();
		this.modelo = carro.getModelo();
		this.fechaCreacion = carro.getFechaCreacion();
		this.idUsuario = carro.getIdUsuario();
		this.numeroPuertas = carro.getNumeroPuertas();
	}
	
	

}
