package com.vehiculo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehiculo.service.entity.Carro;

@Repository
public interface CarroRepository extends VehiculoRepository<Carro, Integer>{

	@Query("from Carro where marca =:marca")
	List<Carro> findCarrosPorMarca(@Param("marca") String marca);
	
	@Query("from Carro where modelo=:modelo")
	public List<Carro> findCarrosPorModelo(@Param("modelo") String modelo);
}
