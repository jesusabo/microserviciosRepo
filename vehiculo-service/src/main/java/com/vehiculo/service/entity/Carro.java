package com.vehiculo.service.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.vehiculo.service.dto.CarroDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carro")
public class Carro extends Vehiculo{
	
	private static final long serialVersionUID = 7598367889177962709L;
	
	@Column(name = "numero_puertas")
	private int numeroPuertas;
	
	public Carro() {
		super();
	}
	
	public Carro(int id, String marca, String modelo, Date fechaCreacion,int idUsuario, int numeroPuertas) {
		super(id, marca, modelo, fechaCreacion, idUsuario);
		this.numeroPuertas = numeroPuertas;
	}
	
	public Carro(CarroDTO carroDTO) {
		this.id= carroDTO.getId();
		this.marca = carroDTO.getMarca();
		this.modelo = carroDTO.getModelo();
		this.fechaCreacion = carroDTO.getFechaCreacion();
		this.idUsuario = carroDTO.getIdUsuario();
		this.numeroPuertas = carroDTO.getNumeroPuertas();
	}
	
}
