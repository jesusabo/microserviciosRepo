package com.vehiculo.service.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiculo.service.entity.Moto;
import com.vehiculo.service.repository.MotoRepository;
import com.vehiculo.service.repository.VehiculoRepository;
import com.vehiculo.service.servicio.MotoService;
import com.vehiculo.service.servicio.VehiculoServiceImpl;


@Service
public class MotoServiceImpl extends VehiculoServiceImpl<Moto, Integer> implements MotoService{
	
	@Autowired
	private MotoRepository motoRepository;

	public MotoServiceImpl(VehiculoRepository<Moto, Integer> vehiculoRepository) {
		super(vehiculoRepository);
	}

}
