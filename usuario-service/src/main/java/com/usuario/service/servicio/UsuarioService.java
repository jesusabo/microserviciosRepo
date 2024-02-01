package com.usuario.service.servicio;

import java.util.List;

import com.usuario.service.dto.CarroDTO;
import com.usuario.service.dto.MotoDTO;
import com.usuario.service.dto.UsuarioDTO;
import com.usuario.service.entity.Usuario;

public interface UsuarioService {	
	
	List<UsuarioDTO> getUsuarioAll();
	
	UsuarioDTO getUsuarioById(int id);
	
	UsuarioDTO saveUsuario(UsuarioDTO usuario);
	
	UsuarioDTO updateUsuario(UsuarioDTO usuario);
	
	void deleteUsuario(int idUsuario);
	
	List<CarroDTO> getCarros();
	
	CarroDTO getCarro(int id);
	
	CarroDTO saveCarro(int idUsuario, CarroDTO carro);
	
	CarroDTO saveCarroExecute(int idUsuario,CarroDTO carro);
	
	MotoDTO getMoto(int id);
	
	MotoDTO saveMoto(MotoDTO moto);
	
	List<MotoDTO> getMotos();

}
