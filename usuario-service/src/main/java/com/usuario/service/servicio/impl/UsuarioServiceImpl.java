package com.usuario.service.servicio.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entity.Usuario;
import com.usuario.service.feignClients.CarroFeignClient;
import com.usuario.service.modelos.Carro;
import com.usuario.service.repository.UsuarioRepository;
import com.usuario.service.servicio.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private CarroFeignClient carroFeignClient;

	@Override
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public List<Carro> getCarros() {
		Carro[] result = restTemplate.getForObject("http://localhost:8081/carro/listar", Carro[].class);
		
		return Arrays.asList(result);
	}

	@Override
	public Carro getCarro(int id) {
		Carro carro =  restTemplate.getForObject("http://localhost:8081/carro/obtener/"+ id, Carro.class);
		return carro;
	}

	@Override
	public Carro saveCarro(int usuarioId, Carro carro) {
		carro.setUsuarioId(usuarioId);
		Carro carronuevo = carroFeignClient.save(carro);
		return carronuevo;
	}

}
