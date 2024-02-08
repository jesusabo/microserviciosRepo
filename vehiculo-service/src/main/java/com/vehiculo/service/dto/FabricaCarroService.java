package com.vehiculo.service.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vehiculo.service.entity.Carro;
import com.vehiculo.service.entity.Vehiculo;

@Service
public class FabricaCarroService {
	
	public CarroDTO converterCarroToCarroDTO(Carro carro) {
		CarroDTO carroDTO = new CarroDTO(carro);
		return carroDTO;
	}
	
	public Carro converterCarroDTOtoCarro(CarroDTO carroDTO) {
		Carro carro = new Carro(carroDTO);
		return carro;
	}
	
	public List<CarroDTO> convertorListCarrosToCarrosDTO(List<Carro> carros){
		List<CarroDTO> carrosDTO = new ArrayList<>();
		carros.forEach(carro -> {
			carrosDTO.add(new CarroDTO(carro));
		});
		
		return carrosDTO;
	}

}
