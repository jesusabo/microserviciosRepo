package com.vehiculo.service.dto;

import org.springframework.stereotype.Service;

import com.vehiculo.service.entity.Moto;

@Service
public class FabricaMotoService {

	
	public Moto crearMoto(MotoDTO motoDTO) {
		return new Moto(motoDTO);
	}
	
	public MotoDTO crearMotoDTO(Moto moto) {
		return new MotoDTO(moto);
	}
	
	
}
