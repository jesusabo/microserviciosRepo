package com.vehiculo.service.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.vehiculo.service.entity.Vehiculo;

@NoRepositoryBean //no se puedan crear instancias del repositorio
public interface VehiculoRepository<E extends Vehiculo, ID extends Serializable> extends JpaRepository<E, ID>{

}
