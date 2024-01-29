package com.carro.service.servicio;

import java.util.List;

import com.carro.service.entity.Carro;

public interface CarroService {
	
	Carro saveCarro(Carro carro);
	
	Carro findById(int id);
	
	List<Carro> getCarroAll();
	
	Carro updateCarro(Carro carro);
	
	void deleteCarro(int idCarro);
	
	
	
}
