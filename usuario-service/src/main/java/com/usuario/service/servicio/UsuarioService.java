package com.usuario.service.servicio;

import java.util.List;

import com.usuario.service.entity.Usuario;
import com.usuario.service.modelos.Carro;

public interface UsuarioService {	
	
	List<Usuario> getAll();
	
	Usuario getUsuarioById(int id);
	
	Usuario save(Usuario usuario);
	
	List<Carro> getCarros();
	
	Carro getCarro(int id);
	
	Carro saveCarro(int idUsuario, Carro carro);
	
	Carro saveCarroExecute(int idUsuario,Carro carro);
	

}
