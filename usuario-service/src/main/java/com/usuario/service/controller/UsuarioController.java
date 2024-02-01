package com.usuario.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.dto.CarroDTO;
import com.usuario.service.dto.MotoDTO;
import com.usuario.service.dto.UsuarioDTO;
import com.usuario.service.entity.Usuario;
import com.usuario.service.servicio.UsuarioService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
		return new ResponseEntity<>(usuarioService.saveUsuario(usuarioDTO),HttpStatus.OK);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable int id){
		return new ResponseEntity<>(usuarioService.getUsuarioById(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<UsuarioDTO>> listarUsuario(){
		return new ResponseEntity<List<UsuarioDTO>>(usuarioService.getUsuarioAll(),HttpStatus.OK);
	}
	
	@PostMapping("/actualizar")
	public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
		return new ResponseEntity<UsuarioDTO>(usuarioService.updateUsuario(usuarioDTO),HttpStatus.OK);
	}
	
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminiarUsuario(@PathVariable int id){	
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<String>("Usuario Eliminado con exito" ,HttpStatus.OK);
	}
	
	@GetMapping("users")
	public void prueba(@RequestParam(value="valor1" ,defaultValue = "leonor" ,required = false) String valor1) {
		log.info("El valor recibido es: "+valor1);
	}
	
	@GetMapping("/carros")
	public ResponseEntity<List<CarroDTO>> obtenerCarroById(){
		return new ResponseEntity<List<CarroDTO>>(usuarioService.getCarros(),HttpStatus.OK);
	}
	
	
	//@CircuitBreaker(name = "carrosCB", fallbackMethod = "fallBackGetCarro")
	@GetMapping("/carro/{id}")
	public ResponseEntity<CarroDTO> obtenerCarroById(@PathVariable int id){
		log.info("obtenerCarroById");
		return new ResponseEntity<CarroDTO>(usuarioService.getCarro(id),HttpStatus.OK);
	}
	
	@PostMapping("/carroService/{usuarioId}")
	public ResponseEntity<CarroDTO> guardarCarro(@PathVariable int usuarioId,@Valid @RequestBody CarroDTO carro){
		CarroDTO nuevoCarro = usuarioService.saveCarro(usuarioId, carro);
		return new ResponseEntity<CarroDTO>(nuevoCarro,HttpStatus.OK);
	}
	
	private ResponseEntity<CarroDTO> fallBackGetCarro(@PathVariable int id, RuntimeException exception){
		return new ResponseEntity("El usaurio: "+id+" no tiene dinero para los carros", HttpStatus.OK);
	}
	
	@GetMapping("/motos")
	public ResponseEntity<List<MotoDTO>> obtenerMotos(){
		log.info("motos");
		return new ResponseEntity<List<MotoDTO>>(usuarioService.getMotos(),HttpStatus.OK);
	}
}
