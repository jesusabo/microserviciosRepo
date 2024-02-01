package com.usuario.service.servicio.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.mapping.Collection;
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

import com.usuario.service.dto.CarroDTO;
import com.usuario.service.dto.MotoDTO;
import com.usuario.service.dto.UsuarioDTO;
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
	
	
	@Autowired
	private FabricaUsuarioService fabricaUsuarioService;

	@Override
	public List<UsuarioDTO> getUsuarioAll() {
		log.info("getAll");
		Sort sort = Sort.by("id").ascending();
		Pageable pageable = PageRequest.of(0,5,sort);
		Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
		return fabricaUsuarioService.crearUsuariosDTO(usuarios.getContent());
	}

	@Override
	public UsuarioDTO getUsuarioById(int id) {
		UsuarioDTO usuarioDTO = fabricaUsuarioService.crearUsuarioDTO(usuarioRepository.findById(id).get());
		
		if(usuarioDTO==null) {
			new ResourceNotFoundException("Usuario", "id", id);
		}
		return usuarioDTO;
	}

	@Override
	public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
		return fabricaUsuarioService.crearUsuarioDTO(usuarioRepository.save(fabricaUsuarioService.crearUsuario(usuarioDTO)));
	}
	
	@Override
	public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {		
		Usuario user = usuarioRepository.findById(usuarioDTO.getId()).orElseThrow(()->new ResourceNotFoundException("Usuario", "id", usuarioDTO.getId()));
		user.setNombre(usuarioDTO.getNombre());		;
		return fabricaUsuarioService.crearUsuarioDTO(usuarioRepository.save(user));
	}

	@Override
	public void deleteUsuario(int idUsuario) {
		usuarioRepository.deleteById(idUsuario);	
	}
	
	@Override
	public List<CarroDTO> getCarros() {
		CarroDTO[] result = restTemplate.getForObject("http://carro-service/carro/listar", CarroDTO[].class);
		
		return Arrays.asList(result);
	}

	@Override
	public CarroDTO getCarro(int id) {
		log.info("getCarro");
		try {
			ResponseEntity<CarroDTO> carroResponse = restTemplate.getForEntity("http://carro-service/carro/obtener/"+ id, CarroDTO.class);
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
	public CarroDTO saveCarro(int usuarioId, CarroDTO carro) {
		log.info("saveCarro");
		carro.setUsuarioId(usuarioId);
		CarroDTO carronuevo = carroFeignClient.save(carro);
		return carronuevo;
	}


	@Override
	public CarroDTO saveCarroExecute(int usuarioId,CarroDTO carro){
		log.info("saveCarroExecute");
		carro.setUsuarioId(usuarioId);
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<CarroDTO> httpEntity = new HttpEntity<>(carro,httpHeaders);
		ResponseEntity<CarroDTO> carroResponse = restTemplate.exchange("http://carro-service/carro/guardar", HttpMethod.POST, httpEntity, CarroDTO.class);
		if(carroResponse.getStatusCode().is2xxSuccessful()) {
			return carroResponse.getBody(); 
		}
		return null;
	}

	@Override
	public MotoDTO getMoto(int id) {
		MotoDTO moto = restTemplate.getForObject("http://moto-service/moto/obtener/{id}", MotoDTO.class,id);
		return moto;
	}

	@Override
	public MotoDTO saveMoto(MotoDTO moto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<MotoDTO> entity = new HttpEntity<>(moto,httpHeaders);
		ResponseEntity<MotoDTO> motoResponse = restTemplate.exchange("http://moto-service/moto/guardar", HttpMethod.GET, entity,MotoDTO.class);
		if(motoResponse.getStatusCode().is2xxSuccessful()) {
			return motoResponse.getBody();
		}
		return null;
	}

	@Override
	public List<MotoDTO> getMotos() {
		log.info("getMotos");
		MotoDTO[] moto = restTemplate.getForObject("http://moto-service/moto/listar", MotoDTO[].class);
		return Arrays.asList(moto);
	}

	

}
