package com.usuario.service.servicio.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.dto.Carro;
import com.usuario.service.dto.Moto;
import com.usuario.service.entity.Usuario;
import com.usuario.service.excepciones.ResourceNotFoundException;
import com.usuario.service.feignClients.CarroFeignClient;
import com.usuario.service.repository.UsuarioRepository;
import com.usuario.service.servicio.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private CarroFeignClient carroFeignClient;

	@Override
	public List<Usuario> getUsuarioAll() {
		log.info("getAll");
		Sort sort = Sort.by("id").ascending();
		Pageable pageable = PageRequest.of(0,5,sort);
		Page<Usuario> usuarios = usuarioRepository.findAll(pageable);		
		return usuarios.getContent();
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return usuarioRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuario", "id", id));
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario updateUsuario(Usuario usuario) {
		Usuario user = usuarioRepository.findById(usuario.getId()).orElseThrow(()->new ResourceNotFoundException("Usuario", "id", usuario.getId()));
		user.setNombre(usuario.getNombre());
		usuarioRepository.save(user);
		return usuario;
	}

	@Override
	public void deleteUsuario(int idUsuario) {
		usuarioRepository.deleteById(idUsuario);	
	}
	
	@Override
	public List<Carro> getCarros() {
		Carro[] result = restTemplate.getForObject("http://carro-service/carro/listar", Carro[].class);
		
		return Arrays.asList(result);
	}

	@Override
	public Carro getCarro(int id) {
		log.info("getCarro");
		try {
			ResponseEntity<Carro> carroResponse = restTemplate.getForEntity("http://carro-service/carro/obtener/"+ id, Carro.class);
			return carroResponse.getBody();			
		} catch (HttpServerErrorException errorException) {
			log.info("En HttpServerErrorException");
			throw new ResourceNotFoundException(errorException.getMessage());
		} catch (Exception e) {
			log.info("En Exception General");
			log.info("-- "+e.getMessage());
			return null;
		}
		
			
	}

	@Override
	public Carro saveCarro(int usuarioId, Carro carro) {
		log.info("saveCarro");
		carro.setUsuarioId(usuarioId);
		Carro carronuevo = carroFeignClient.save(carro);
		return carronuevo;
	}


	@Override
	public Carro saveCarroExecute(int usuarioId,Carro carro){
		log.info("saveCarroExecute");
		carro.setUsuarioId(usuarioId);
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<Carro> httpEntity = new HttpEntity<>(carro,httpHeaders);
		ResponseEntity<Carro> carroResponse = restTemplate.exchange("http://carro-service/carro/guardar", HttpMethod.POST, httpEntity, Carro.class);
		if(carroResponse.getStatusCode().is2xxSuccessful()) {
			return carroResponse.getBody(); 
		}
		return null;
	}

	@Override
	public Moto getMoto(int id) {
		Moto moto = restTemplate.getForObject("http://moto-service/moto/obtener/{id}", Moto.class,id);
		return moto;
	}

	@Override
	public Moto saveMoto(Moto moto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<Moto> entity = new HttpEntity<>(moto,httpHeaders);
		ResponseEntity<Moto> motoResponse = restTemplate.exchange("http://moto-service/moto/guardar", HttpMethod.GET, entity,Moto.class);
		if(motoResponse.getStatusCode().is2xxSuccessful()) {
			return motoResponse.getBody();
		}
		return null;
	}

	@Override
	public List<Moto> getMotos() {
		log.info("getMotos");
		Moto[] moto = restTemplate.getForObject("http://moto-service/moto/listar", Moto[].class);
		return Arrays.asList(moto);
	}

	

}
