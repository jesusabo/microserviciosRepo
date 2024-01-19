package com.moto.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entity.Moto;
import com.moto.service.repository.MotoRepository;

@Service
public class MotoServiceImpl implements MotoService{
	
	@Autowired
	MotoRepository motoRepository;

	@Override
	public Moto save(Moto moto) {
		return motoRepository.save(moto);
	}

	@Override
	public Moto findById(int id) {
		return motoRepository.findById(id).get();
	}

	@Override
	public List<Moto> findAll() {
		return motoRepository.findAll();
	}

}
