package com.vehiculo.service.servicio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.vehiculo.service.entity.Vehiculo;
import com.vehiculo.service.excepciones.UsuarioNoEncontradoException;
import com.vehiculo.service.repository.VehiculoRepository;
import com.vehiculo.service.util.Utilitario;

public abstract class VehiculoServiceImpl<E extends Vehiculo, ID extends Serializable> implements VehiculoService<E, ID>{
	
	protected VehiculoRepository<E, ID> vehiculoRepository;
	
	
	public VehiculoServiceImpl(VehiculoRepository<E, ID> vehiculoRepository) {
		this.vehiculoRepository=vehiculoRepository;
	}


	@Override
	public E save(E entity) {
		try {
			System.out.println("Service--: "+entity.getFechaCreacion());
			String fecha1 = Utilitario.convertDateToString(entity.getFechaCreacion(), "dd/MM/yyyy");
			Date fecha2 = Utilitario.convertStringToDate(fecha1, "dd/MM/yyy");
			entity.setFechaCreacion(fecha2);
			entity = vehiculoRepository.save(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return entity;
	}


	@Override
	public E findById(ID id) {
		System.out.println("[[ VehiculoServiceImpl [ findById: "+id);
		return vehiculoRepository.findById(id).orElseThrow(()->new UsuarioNoEncontradoException("Carro",(Integer)id,"0001"));
//		try {
//			Optional<E> entityoptional = vehiculoRepository.findById(id);
//			return entityoptional.get();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
	}


	@Override
	public List<E> findAll() {
		System.out.println("[[ VehiculoServiceImpl [ findAll ");
		try {
			List<E> entities = vehiculoRepository.findAll();
			return entities;	
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}


	@Override
	public E update(E entity) {
		System.out.println("[[ VehiculoServiceImpl [ update : "+entity);
		try {
//			Optional<E> entityOptional = vehiculoRepository.findById(id);			
//			E entityUpdate = entityOptional.get();
			return vehiculoRepository.save(entity);
		} catch (Exception e) {
			return null;
		}		
	}


	@Override
	public void delete(ID id) {		
		try {			
			vehiculoRepository.deleteById(id);	
		} catch (Exception e) {
			throw new UsuarioNoEncontradoException("Carro", (Integer)id, "0002");
		}
		
	}
	
	
	
	

}
