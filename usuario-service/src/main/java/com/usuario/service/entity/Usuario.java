package com.usuario.service.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.usuario.service.dto.UsuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	

	private String nombre;
	
	private String apellido;
	
	private String email;

	private Date fechaNacimiento;

	public Usuario(UsuarioDTO usuarioDTO) {
		super();
		this.nombre = usuarioDTO.getNombre();
		this.apellido= usuarioDTO.getApellido();
		this.email = usuarioDTO.getEmail();
		this.fechaNacimiento = usuarioDTO.getFechaNacimiento();
	}
	
	
	
	
	

}
