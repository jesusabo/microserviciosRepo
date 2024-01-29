package com.carro.service.servicio.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.service.controller.CarroError;
import com.carro.service.entity.Carro;
import com.carro.service.repository.CarroRepository;
import com.carro.service.servicio.CarroService;

@Service
public class CarroServiceImpl implements CarroService{

	protected static final Logger log = org.slf4j.LoggerFactory.getLogger(CarroServiceImpl.class);
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Override
	public Carro saveCarro(Carro carro) {
		log.info("saveCarro");
		return carroRepository.save(carro);
	}

	@Override
	public Carro findById(int id){
		log.info("findById");		
		return carroRepository.findById(id).orElseThrow(()-> new CarroError("Carro", id, "0001"));
	}

	@Override
	public List<Carro> getCarroAll() {
		log.info("getCarroAll");
		return carroRepository.findAll();
	}

	@Override
	public Carro updateCarro(Carro carro) {
		log.info("updateCarro");
		Carro carroObtenido = carroRepository.getById(carro.getId());
		carroObtenido.setMarca(carro.getMarca());
		return carroRepository.save(carroObtenido);
	}

	@Override
	public void deleteCarro(int idCarro) {
		log.info("deleteCarro");
		carroRepository.deleteById(idCarro);
	}

}
