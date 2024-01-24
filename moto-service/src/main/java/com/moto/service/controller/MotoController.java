package com.moto.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entity.Moto;
import com.moto.service.servicio.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {

	@Autowired
	MotoService motoService;
	
	@PostMapping("/guardar")
	public ResponseEntity<Moto> crear(@RequestBody Moto moto) {
		return new ResponseEntity<Moto>(motoService.guardar(moto), HttpStatus.OK);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable int id){
		return new ResponseEntity<Moto>(motoService.buscarPorId(id),HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Moto>> obtenerMotos(){
		return new ResponseEntity<>(motoService.listarMotos(), HttpStatus.OK);
	}
	
}
