package com.carro.service.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.service.entity.Carro;
import com.carro.service.repository.CarroRepository;
import com.carro.service.servicio.CarroService;

@Service
public class CarroServiceImpl implements CarroService{

	@Autowired
	private CarroRepository carroRepository;
	
	@Override
	public Carro save(Carro carro) {
		return carroRepository.save(carro);
	}

	@Override
	public Carro findById(int id) {
		return carroRepository.findById(id).get();
	}

	@Override
	public List<Carro> getAll() {
		return carroRepository.findAll();
	}

}
