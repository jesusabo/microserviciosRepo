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
	
	@NotEmpty(message = "El nombre no debe ser vacio")
	@Size(min = 8, message = "El  nombre debe tener al menos 3 caracteres")
	private String nombre;
	
	@Email(message = "El email debe tener un formato correcto")
	private String email;
	
	@Column(name = "fec_nac")
	private Date fechaNacimiento;
	
	

}
