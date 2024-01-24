package com.usuario.service.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moto {

	private int id;
	private String marca;
	private String modelo;
	private int usuarioId;

}
