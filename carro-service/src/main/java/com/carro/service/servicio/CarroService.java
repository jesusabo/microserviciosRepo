package com.carro.service.servicio;

import java.util.List;

import com.carro.service.entity.Carro;

public interface CarroService {
	
	Carro save(Carro carro);
	
	Carro findById(int id);
	
	List<Carro> getAll();
	
	
	
}
