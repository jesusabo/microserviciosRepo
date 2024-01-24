package com.moto.service.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entity.Moto;
import com.moto.service.repository.MotoRepository;
import com.moto.service.servicio.MotoService;

@Service
public class MotoServicioImpl implements MotoService{
	
	@Autowired
	MotoRepository motoRepository;

	@Override
	public Moto guardar(Moto moto) {
		return motoRepository.save(moto);
	}

	@Override
	public Moto buscarPorId(int id) {
		return motoRepository.findById(id).get();
	}

	@Override
	public List<Moto> listarMotos() {
		return motoRepository.findAll();
	}

	@Override
	public Moto actualizar(Moto moto) {
		return motoRepository.save(moto);
	}

}
