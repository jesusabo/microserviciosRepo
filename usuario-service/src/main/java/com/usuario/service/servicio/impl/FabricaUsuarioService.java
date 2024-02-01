package com.usuario.service.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.usuario.service.dto.UsuarioDTO;
import com.usuario.service.entity.Usuario;


@Service
public class FabricaUsuarioService {

	public UsuarioDTO crearUsuarioDTO(Usuario usuario) {
		return new UsuarioDTO(usuario);
	}
	
	public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO);
	}
	
	
	public List<UsuarioDTO> crearUsuariosDTO(List<Usuario> usuarios){
		List<UsuarioDTO> usuariosDTO = new ArrayList();
		usuarios.stream().forEach(usuario -> {usuariosDTO.add(new UsuarioDTO(usuario));});
		return usuariosDTO;
	}
	
}
