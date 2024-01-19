package com.moto.service.servicio;

import java.util.List;

import com.moto.service.entity.Moto;

public interface MotoService {
	
	Moto save(Moto moto);
	
	Moto findById(int id);
	
	List<Moto> findAll();

}
