package com.carro.service.controller;

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

import com.carro.service.entity.Carro;
import com.carro.service.servicio.CarroService;


@RestController
@RequestMapping("/carro")
public class CarroController {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(CarroController.class);

	@Autowired
	private CarroService carroService;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
		log.info("guardar carro ID");
		return new ResponseEntity<>(carroService.save(carro),HttpStatus.OK);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<Carro> obtenerCarro(@PathVariable int id){
		log.info("obtener carro por ID");
		return new ResponseEntity<>(carroService.findById(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Carro>> listarCarro(){
		log.info("obtener lista de carros");
		List<Carro> carros = carroService.getAll();
		return new ResponseEntity<List<Carro>>(carros,HttpStatus.OK);
	}
	
}
