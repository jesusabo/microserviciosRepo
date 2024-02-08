package com.vehiculo.service.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 7803757119192902226L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	protected String marca;
	
	protected String modelo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	protected Date fechaCreacion;
	
	@Column(name="id_usuario")
	protected int idUsuario;

	public Vehiculo(int id, String marca, String modelo, Date fechaCreacion, int idUsuario) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaCreacion = fechaCreacion;
		this.idUsuario=idUsuario;
	}
	
	

}
