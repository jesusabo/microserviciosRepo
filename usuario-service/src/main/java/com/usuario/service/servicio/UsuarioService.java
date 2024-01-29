package com.usuario.service.servicio;

import java.util.List;

import com.usuario.service.dto.Carro;
import com.usuario.service.dto.Moto;
import com.usuario.service.entity.Usuario;

public interface UsuarioService {	
	
	List<Usuario> getUsuarioAll();
	
	Usuario getUsuarioById(int id);
	
	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario(Usuario usuario);
	
	void deleteUsuario(int idUsuario);
	
	List<Carro> getCarros();
	
	Carro getCarro(int id);
	
	Carro saveCarro(int idUsuario, Carro carro);
	
	Carro saveCarroExecute(int idUsuario,Carro carro);
	
	Moto getMoto(int id);
	
	Moto saveMoto(Moto moto);
	
	List<Moto> getMotos();

}
