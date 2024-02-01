package com.usuario.service.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.usuario.service.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private int id;
	
	@Size(min = 3,message = "El nombre debe tener al menos 3 caracteres")
	private String nombre;
	
	@NotEmpty(message = "El apellido no puede estar vacio")
	private String apellido;
	
	@Email(message = "El email debe tener un formato correcto")
	@NotEmpty
	private String email;

	
	private Date fechaNacimiento;

	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.email = usuario.getEmail();
		this.fechaNacimiento = usuario.getFechaNacimiento();
	}
	
	
	
}
