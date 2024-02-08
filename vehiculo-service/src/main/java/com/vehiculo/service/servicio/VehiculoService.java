package com.vehiculo.service.servicio;

import java.io.Serializable;
import java.util.List;

import com.vehiculo.service.entity.Vehiculo;

public interface VehiculoService<E extends Vehiculo, ID extends Serializable> {

	public E save(E entity);
	
	public E findById(ID id);
	
	public List<E> findAll();
	
	public E update(E entity);
	
	public void delete(ID id);

}
