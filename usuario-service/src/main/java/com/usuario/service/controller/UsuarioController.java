package com.usuario.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entity.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.servicio.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.save(usuario),HttpStatus.OK);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable int id){
		return new ResponseEntity<>(usuarioService.getUsuarioById(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listarUsuario(){
		List<Usuario> usuarios = usuarioService.getAll();
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
	
	@GetMapping("/carros")
	public ResponseEntity<List<Carro>> obtenerCarroById(){
		return new ResponseEntity<List<Carro>>(usuarioService.getCarros(),HttpStatus.OK);
	}
	
	@GetMapping("/carro/{id}")
	public ResponseEntity<Carro> obtenerCarroById(@PathVariable int id){
		log.info("obtenerCarroById");
		return new ResponseEntity<Carro>(usuarioService.getCarro(id),HttpStatus.OK);
	}
	
	@PostMapping("/carroService/{usuarioId}")
	public ResponseEntity<Carro> guardarCarro(@PathVariable int usuarioId,@RequestBody Carro carro){
		Carro nuevoCarro = usuarioService.saveCarro(usuarioId, carro);
		return new ResponseEntity<Carro>(nuevoCarro,HttpStatus.OK);
	}
}
