package com.vehiculo.service.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.vehiculo.service.dto.MotoDTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="moto")
public class Moto extends Vehiculo{

	private static final long serialVersionUID = 3999361861540313561L;
	
	@Column(name="numero_ruedas")
	private int numeroRuedas;
	
	
	public Moto(int id, String marca, String modelo, Date fechaCreacion, int idUsuario, int numeroRuedas) {
		super(id, marca, modelo, fechaCreacion, idUsuario);
		this.numeroRuedas=numeroRuedas;
	}
	
	public Moto(MotoDTO motoDTO) {
		this.id= motoDTO.getId();
		this.marca = motoDTO.getMarca();
		this.modelo = motoDTO.getModelo();
		this.fechaCreacion = motoDTO.getFechaCreacion();
		this.idUsuario = motoDTO.getIdUsuario();
		this.numeroRuedas = motoDTO.getNumeroRuedas();
	}
}
