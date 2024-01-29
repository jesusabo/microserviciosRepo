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

import com.usuario.service.dto.Carro;
import com.usuario.service.dto.Moto;
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
	public ResponseEntity<Usuario> guardarUsuario(@Valid @RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.saveUsuario(usuario),HttpStatus.OK);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable int id){
		return new ResponseEntity<>(usuarioService.getUsuarioById(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listarUsuario(){
		List<Usuario> usuarios = usuarioService.getUsuarioAll();
		log.info(usuarios.get(0).getNombre());
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
	
	@PostMapping("/actualizar")
	public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(usuarioService.updateUsuario(usuario),HttpStatus.OK);
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
	public ResponseEntity<List<Carro>> obtenerCarroById(){
		return new ResponseEntity<List<Carro>>(usuarioService.getCarros(),HttpStatus.OK);
	}
	
	
	//@CircuitBreaker(name = "carrosCB", fallbackMethod = "fallBackGetCarro")
	@GetMapping("/carro/{id}")
	public ResponseEntity<Carro> obtenerCarroById(@PathVariable int id){
		log.info("obtenerCarroById");
		return new ResponseEntity<Carro>(usuarioService.getCarro(id),HttpStatus.OK);
	}
	
	@PostMapping("/carroService/{usuarioId}")
	public ResponseEntity<Carro> guardarCarro(@PathVariable int usuarioId,@Valid @RequestBody Carro carro){
		Carro nuevoCarro = usuarioService.saveCarro(usuarioId, carro);
		return new ResponseEntity<Carro>(nuevoCarro,HttpStatus.OK);
	}
	
	private ResponseEntity<Carro> fallBackGetCarro(@PathVariable int id, RuntimeException exception){
		return new ResponseEntity("El usaurio: "+id+" no tiene dinero para los carros", HttpStatus.OK);
	}
	
	@GetMapping("/motos")
	public ResponseEntity<List<Moto>> obtenerMotos(){
		log.info("motos");
		return new ResponseEntity<List<Moto>>(usuarioService.getMotos(),HttpStatus.OK);
	}
}
