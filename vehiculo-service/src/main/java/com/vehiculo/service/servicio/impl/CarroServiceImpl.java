package com.vehiculo.service.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiculo.service.entity.Carro;
import com.vehiculo.service.repository.CarroRepository;
import com.vehiculo.service.repository.VehiculoRepository;
import com.vehiculo.service.servicio.CarroService;
import com.vehiculo.service.servicio.VehiculoServiceImpl;

@Service
public class CarroServiceImpl extends VehiculoServiceImpl<Carro, Integer> implements CarroService{
	
	@Autowired
	private CarroRepository carroRepository;

	public CarroServiceImpl(VehiculoRepository<Carro, Integer> vehiculoRepository) {
		super(vehiculoRepository);
	}

	
	@Override
	public List<Carro> findByMarca(String marca) {
		return carroRepository.findCarrosPorMarca(marca);
	}

	@Override
	public List<Carro> findByModelo(String modelo) {
		return carroRepository.findCarrosPorModelo(modelo);
	}
	
	
	

	
	//desarrollar los metdos especificos para carro
	
	
}
