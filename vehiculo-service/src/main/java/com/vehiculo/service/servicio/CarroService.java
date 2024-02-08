package com.vehiculo.service.servicio;

import java.util.List;

import com.vehiculo.service.entity.Carro;

public interface CarroService extends VehiculoService<Carro, Integer>{

	List<Carro> findByMarca(String marca);
	List<Carro> findByModelo(String modelo);
}
