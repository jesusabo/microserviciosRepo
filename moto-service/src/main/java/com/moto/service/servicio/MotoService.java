package com.moto.service.servicio;

import java.util.List;

import com.moto.service.entity.Moto;

public interface MotoService {
	
	Moto guardar(Moto moto);
	
	Moto buscarPorId(int id);
	
	List<Moto> listarMotos();
	
	Moto actualizar(Moto moto);
	
	

}
